package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TmdbConnection {
    private static BufferedReader br;
    private HttpURLConnection con;
    private URL url;

    TmdbConnection() {
        try {
            url = new URL("https://api.themoviedb.org/3/movie/550?api_key=96e922a6bdf38660f798b285e289fd8a");
            con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            br = new BufferedReader(new InputStreamReader((con.getInputStream())));
        } catch (MalformedURLException mue) {
            System.out.println(mue.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());

        }
    }

    public  String present() throws IOException {
        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            return output;
        }
        return "koniec";
    }
}
