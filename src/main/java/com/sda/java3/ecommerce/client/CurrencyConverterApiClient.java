package com.sda.java3.ecommerce.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class CurrencyConverterApiClient {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static void main(String[] args) {
        String baseCurrency = "USD";
        String targetCurrency = "EUR";
        String url = API_URL + baseCurrency;

        HttpURLConnection connection = null;
        try {
            // Create a URL object with the API endpoint
            URL apiUrl = URI.create(url).toURL();

            // Open a connection to the API URL
            connection = (HttpURLConnection) apiUrl.openConnection();

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

                    // Extract the exchange rate from the JSON response
                    String responseBody = content.toString();
                    int startIndex = responseBody.indexOf("\"" + targetCurrency + "\":");
                    if (startIndex != -1) {
                        int endIndex = responseBody.indexOf(",", startIndex);
                        String exchangeRate = responseBody.substring(startIndex + 6 + targetCurrency.length(), endIndex);
                        System.out.println("Exchange Rate: " + exchangeRate);
                    } else {
                        System.out.println("Currency not found.");
                    }
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
