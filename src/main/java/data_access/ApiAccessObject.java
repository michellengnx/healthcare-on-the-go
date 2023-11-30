package data_access;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.CreateRequest.InvalidLocationException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiAccessObject {
    private String apiKey;

    public ApiAccessObject(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Get the distance from a start to an end location
     *
     * @param start The start location
     * @param end The end location
     * @return The distance from start to end
     * @throws InvalidLocationException One of the inputted locations has invalid
     */
    public float getDistance(String start, String end) throws InvalidLocationException {
        return requestDistanceAndEta(start, end).get("distance");
    }

    /**
     * Get the ETA from a start to an end location
     *
     * @param start The start location
     * @param end The end location
     * @return The ETA from start to end
     * @throws InvalidLocationException One of the inputted locations has invalid
     */
    public float getEta(String start, String end) throws InvalidLocationException {
        return requestDistanceAndEta(start, end).get("eta");
    }

    /**
     * Get the price from a start to an end location
     *
     * @param start The start location
     * @param end The end location
     * @return The travel price from start to end
     * @throws InvalidLocationException One of the inputted locations has invalid
     */
    public float getPrice(String start, String end) throws InvalidLocationException {
        return requestDistanceAndEta(start, end).get("distance") * 0.1f;
    }

    /**
     * Return an image URL that displays a route from the start to the end location
     *
     * @param start The start location
     * @param end The end location
     * @return A URL for an image that displays a route from start to end
     * @throws InvalidLocationException One of the inputted locations has invalid
     */
    public String getTrafficMap(String start, String end) throws InvalidLocationException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("www.mapquestapi.com")
                .addPathSegment("staticmap")
                .addPathSegment("v5")
                .addPathSegment("map")
                .addQueryParameter("key", this.apiKey)
                .addQueryParameter("start", start)
                .addQueryParameter("end", end)
                .build();

        Request request = new Request.Builder().url(httpUrl).build();

        try {
            // execute and print API response
            Response response = client.newCall(request).execute();
            System.out.println("Response : " + response);
            if (response.code() == 200) {
                JSONObject responseBody = new JSONObject(response.body().string());
                return responseBody.getString("url");
            } else {
                throw new InvalidLocationException("Invalid location");
            }
        } catch (IOException | JSONException e) {
            throw new InvalidLocationException("Invalid location");
        }
    }

    /**
     * Helper function that calls the api and requests routing information. Returns information relevant to
     * the public methods. This function ought ot be modified if more public methods are added.
     *
     * @param start The start location
     * @param end The end location
     * @return Map from strings that denote fields, to floats, that denote information corresponding to said field
     * @throws InvalidLocationException Either the start or end location was invalid
     */
    private Map<String, Float> requestDistanceAndEta(String start, String end) throws InvalidLocationException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("www.mapquestapi.com")
                .addPathSegment("directions")
                .addPathSegment("v2")
                .addPathSegment("route")
                .addQueryParameter("key", this.apiKey)
                .addQueryParameter("from", start)
                .addQueryParameter("to", end)
                .build();

        Request request = new Request.Builder().url(httpUrl).build();

        try {
            // execute and print API response
            Response response = client.newCall(request).execute();
            System.out.println("Response : " + response);
            if (response.code() == 200) {
                JSONObject responseBody = new JSONObject(response.body().string());

                JSONObject route = responseBody.getJSONObject("route");
                Map<String, Float> distanceEtaMap = new HashMap<>();
                distanceEtaMap.put("distance", route.getFloat("distance") / 10);
                distanceEtaMap.put("eta", (float) route.getInt("time"));
                return distanceEtaMap;
            } else {
                throw new InvalidLocationException("Invalid location");
            }
        } catch (IOException | JSONException e) {
            throw new InvalidLocationException("Invalid location");
        }
    }

}
