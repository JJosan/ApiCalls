package net.glubglub.apicall;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Helpers {

    // http json return body
    public static String Anime() {
        String result = "";
        try {
            URL url = new URL("https://animechan.vercel.app/api/random");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                Gson g = new Gson();
                // anime, character, quote json object into hashmap
                HashMap<String, String> map = g.fromJson(sb.toString(), HashMap.class);
                result = map.get("quote");
            }
            con.disconnect();
            return result;
        } catch (MalformedURLException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return result;
    }

    // http single line txt body
    public static String Insult() {
        String result = "";
        try {
            // anime, character, quote
            URL url = new URL("https://evilinsult.com/generate_insult.php?lang=en&amp;type=json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                result = sb.toString();
            }
            con.disconnect();
            return result;
        } catch (MalformedURLException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return result;
    }

    // http post. calls from my local server
    public static void Upload(String name) {
        try {
            URL url = new URL("http://localhost:3000/api/v1/poop?name=" + name);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            if(con.getResponseCode() == 200) {
                System.out.println("SUCCESS");
            }
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
