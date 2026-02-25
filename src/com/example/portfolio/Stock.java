package com.example.portfolio;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private static final Map<String, Stock> registry = new HashMap<>();

    private final String symbol;
    private float currentPrice;

    private Stock(String symbol, float currentPrice) {
        this.symbol = symbol;
        this.currentPrice = currentPrice;
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

    private void setCurrentPrice(float price) {
        this.currentPrice = price;
    }
}

