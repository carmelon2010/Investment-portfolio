package com.example.portfolio;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Stock {
    private static final String API_KEY = "d6gvih9r01qoor9mn0hgd6gvih9r01qoor9mn0i0";

    private static final Map<String, Stock> registry = new HashMap<>();

    private final String symbol;
    private float currentPrice;

    private Stock(String symbol, float currentPrice) {
        this.symbol = symbol;
        this.currentPrice = currentPrice;
    }

    public void refreshPrice() {
        String url = String.format("https://finnhub.io/api/v1/quote?symbol=%s&token=%s", symbol, API_KEY);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
            
            currentPrice = Float.parseFloat(response.body().split("\"c\":")[1].split(",")[0]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Stock getInstance(String symbol, float initialPrice) {
        return registry.computeIfAbsent(symbol, s -> new Stock(s, initialPrice));
    }

    public static Stock getInstance(String symbol) {
        return registry.get(symbol);
    }

    public String getSymbol() {
        return symbol;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float price) {
        this.currentPrice = price;
    }
}

