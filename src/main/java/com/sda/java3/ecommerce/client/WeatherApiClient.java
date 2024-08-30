package com.sda.java3.ecommerce.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApiClient {

    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=your_api_key";

    public static void main(String[] args) {
        HttpURLConnection connection = null;
        try {
            // Create a URL object with the API endpoint
            URL url = new URL(API_URL);

            // Open a connection to the API URL
            connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Get the response code from the server
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // If the response code is 200 (HTTP OK), read the response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {

                    String inputLine;
                    StringBuilder content = new StringBuilder();

                    // Read the response line by line
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }

                    // Print the response
                    System.out.println("Response Content: " + content.toString());
                }
            } else {
                System.out.println("GET request failed.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
