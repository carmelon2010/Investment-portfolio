package com.example.portfolio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;

public final class FinnhubApiHelper {
    private static final String API_KEY = "d6h1h21r01qnjncn0i3gd6h1h21r01qnjncn0i40";

    private String sendGet(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getQuote(String symbol) {
        String url = String.format("https://finnhub.io/api/v1/quote?symbol=%s&token=%s", symbol, API_KEY);
        return sendGet(url);
    }

    public String searchSymbol(String query) {
        String url = String.format("https://finnhub.io/api/v1/search?q=%s&token=%s", query, API_KEY);
        return sendGet(url);
    }

    public String getStockProfile(String symbol) {
        String url = String.format("https://finnhub.io/api/v1/stock/profile2?symbol=%s&token=%s", symbol, API_KEY);
        return sendGet(url);
    }

    public String getCompanyNews(String symbol, LocalDate from, LocalDate to) {
        String url = String.format(
                "https://finnhub.io/api/v1/company-news?symbol=%s&from=%s&to=%s&token=%s",
                symbol, from, to, API_KEY
        );
        return sendGet(url);
    }

    public String getRecommendationTrends(String symbol) {
        String url = String.format(
                "https://finnhub.io/api/v1/stock/recommendation?symbol=%s&token=%s",
                symbol, API_KEY
        );
        return sendGet(url);
    }

    public String getBasicFinancials(String symbol) {
        String url = String.format(
                "https://finnhub.io/api/v1/stock/metric?symbol=%s&metric=all&token=%s",
                symbol, API_KEY
        );
        return sendGet(url);
    }

    public String getStockSymbols(String exchange) {
        String url = String.format(
                "https://finnhub.io/api/v1/stock/symbol?exchange=%s&token=%s",
                exchange, API_KEY
        );
        return sendGet(url);
    }

    public String getForexSymbols(String exchange) {
        String url = String.format(
                "https://finnhub.io/api/v1/forex/symbol?exchange=%s&token=%s",
                exchange, API_KEY
        );
        return sendGet(url);
    }

    public String getCryptoSymbols(String exchange) {
        String url = String.format(
                "https://finnhub.io/api/v1/crypto/symbol?exchange=%s&token=%s",
                exchange, API_KEY
        );
        return sendGet(url);
    }

    
    public String getEtfProfile(String symbol) {
        String url = String.format(
                "https://api.finnhub.io/api/v1/etf/profile?symbol=%s&token=%s",
                symbol,
                API_KEY
        );
        return sendGet(url);
    }

    public String getStockCandles(String symbol, String resolution, long from, long to) {
        String url = String.format(
                "https://finnhub.io/api/v1/stock/candle?symbol=%s&resolution=%s&from=%d&to=%d&token=%s",
                symbol, resolution, from, to, API_KEY
        );
        return sendGet(url);
    }

    public String getForexCandles(String symbol, String resolution, long from, long to) {
        String url = String.format(
                "https://finnhub.io/api/v1/forex/candle?symbol=%s&resolution=%s&from=%d&to=%d&token=%s",
                symbol, resolution, from, to, API_KEY
        );
        return sendGet(url);
    }

    public String getCryptoCandles(String symbol, String resolution, long from, long to) {
        String url = String.format(
                "https://finnhub.io/api/v1/crypto/candle?symbol=%s&resolution=%s&from=%d&to=%d&token=%s",
                symbol, resolution, from, to, API_KEY
        );
        return sendGet(url);
    }
}