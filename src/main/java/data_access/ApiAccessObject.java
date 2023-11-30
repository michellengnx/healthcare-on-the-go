package data_access;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.CreateRequest.ApiAccessException;
import use_case.CreateRequest.InvalidLocationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiAccessObject {
    private final String apiKey;

    public ApiAccessObject(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Get the distance from a start to an end location in km
     *
     * @param start The start location
     * @param end The end location
     * @return The distance from start to end
     * @throws InvalidLocationException One of the inputted locations has invalid
     */
    public float getDistance(String start, String end) throws InvalidLocationException, ApiAccessException {
        List<String> fields = new ArrayList<>();
        fields.add("distance");
        return requestRoutingData(start, end, fields).get("distance") / 10;
    }

    /**
     * Get the ETA from a start to an end location in minutes
     *
     * @param start The start location
     * @param end The end location
     * @return The ETA from start to end
     * @throws InvalidLocationException One of the inputted locations has invalid
     */
    public float getEta(String start, String end) throws InvalidLocationException, ApiAccessException {
        List<String> fields = new ArrayList<>();
        fields.add("time");
        return requestRoutingData(start, end, fields).get("time") / 60;
    }

    /**
     * Get the price from a start to an end location
     *
     * @param start The start location
     * @param end The end location
     * @return The travel price from start to end
     * @throws InvalidLocationException One of the inputted locations has invalid
     */
    public float getPrice(String start, String end) throws InvalidLocationException, ApiAccessException {
        List<String> fields = new ArrayList<>();
        fields.add("time");
        fields.add("distance");
        Map<String, Float> routingData = requestRoutingData(start, end, fields);
        return routingData.get("distance") * 0.05f + routingData.get("time") * 0.002f;
    }

    /**
     * Return an image URL that displays a route from the start to the end location
     *
     * @param start The start location
     * @param end The end location
     * @return A URL for an image that displays a route from start to end
     * @throws InvalidLocationException One of the inputted locations has invalid
     */
    public String getTrafficMap(String start, String end) throws InvalidLocationException, ApiAccessException {
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
            if (response.code() == 200) {
                return request.url().toString();
            } else {
                throw new ApiAccessException();
            }
        } catch (IOException | JSONException e) {
            throw new InvalidLocationException("Invalid location");
        }
    }

    /**
     * Helper function that calls the api and requests routing information
     *
     * @param start The start location
     * @param end The end location
     * @param fields The fields of data requested
     * @return Map from strings that denote fields, to floats, that denote information corresponding to said field
     * @throws InvalidLocationException Either the start or end location was invalid
     */
    private Map<String, Float> requestRoutingData(String start, String end, List<String> fields) throws InvalidLocationException, ApiAccessException {
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
                for (String field : fields) {
                    distanceEtaMap.put(field, route.getFloat(field));
                }

                return distanceEtaMap;
            } else {
                throw new ApiAccessException();
            }
        } catch (IOException | JSONException e) {
            throw new InvalidLocationException("Invalid location");
        }
    }
}
