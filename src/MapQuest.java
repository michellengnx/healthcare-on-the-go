//import okhttp3.*;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//
//public class Something {
//    public static void main(String[] args) {
//        OkHttpClient client = new OkHttpClient();
//
//        HttpUrl httpUrl = new HttpUrl.Builder()
//                .scheme("https")
//                .host("www.mapquestapi.com")
//                .addPathSegment("directions")
//                .addPathSegment("v2")
//                .addPathSegment("route")
//                .addQueryParameter("key", "KEY")
//                .addQueryParameter("from", "University of Toronto")
//                .addQueryParameter("to", "York Univerisity")
//                .build();
//
//        Request request = new Request.Builder().url(httpUrl).build();
//
//        try {
//            // execute and print API response
//            Response response = client.newCall(request).execute();
//            System.out.println("Response : " + response);
//            if (response.code() == 200) {
//                JSONObject responseBody = new JSONObject(response.body().string());
//
//                JSONObject route = responseBody.getJSONObject("route");
//                float distance = route.getFloat("distance") / 10;
//                int eta = route.getInt("time");
//
//                System.out.format("Distance : %f miles, ETA : %d seconds", distance, eta);
//            } else {
//                System.out.format("Request Failed, error code : %d", response.code());
//            }
//        } catch (IOException | JSONException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}
