package com.travel;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APITest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/home/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("accept", "application/json");


            String input = "\"Username\":\"vinujadaun\", \"password\":\"vinujadaun\"";
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
