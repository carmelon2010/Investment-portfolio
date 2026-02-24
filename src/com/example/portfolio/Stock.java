package com.example.portfolio;

public class Stock {
    private final String symbol;
    private float currentPrice;

    public Stock(String symbol, float currentPrice) {
        this.symbol = symbol;
        this.currentPrice = currentPrice;
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

