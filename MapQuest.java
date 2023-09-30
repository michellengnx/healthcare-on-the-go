package org.example;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class MapQuest {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("www.mapquestapi.com")
                .addPathSegment("directions")
                .addPathSegment("v2")
                .addPathSegment("route")
                .addQueryParameter("key", "pnI7fJLjm5NikjPKjrFHxFb1oW7rwmWx")
                .addQueryParameter("from", "University of Toronto")
                .addQueryParameter("to", "York Univerisity")
                .build();

        Request request = new Request.Builder().url(httpUrl).build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);
            JSONObject responseBody = new JSONObject(response.body().string());
            System.out.println(responseBody);

            JSONObject route = responseBody.getJSONObject("route");
            float distance = route.getFloat("distance") / 10;
            int eta = route.getInt("time");

            System.out.format("Distance : %f miles, ETA : %d seconds", distance, eta);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
