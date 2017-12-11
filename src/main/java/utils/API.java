package utils;


import data.scraping.yelp.Configurations;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {

    public JSONObject GET(String requestUrl, Configurations confg){

        JSONObject response = new JSONObject();
        String jsonResponse = null;
        HttpURLConnection con = null;
        try {
            URL url = new URL(requestUrl);
            con = (HttpURLConnection) url.openConnection();
            if (confg != null){
                con.setRequestProperty ("Authorization", confg.getKey());
            }
            con.setRequestMethod("GET");
            con.setDoOutput(true);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            con.getInputStream()));

            int responseCode = con.getResponseCode();

            String responseMsg = con.getResponseMessage();

            if (responseCode == 200) {

                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line+"\n");
                }

                System.out.println(sb);

                br.close();

                JSONParser parse = new JSONParser();
                response = (JSONObject) parse.parse(sb.toString());

                System.out.println("done");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        con.disconnect();

        return response;

    }

}
