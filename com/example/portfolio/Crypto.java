package com.example.portfolio;

public final class Crypto extends FinancialAsset {
    private final String exchange;

    public Crypto(String symbol, float currentPrice, String exchange) {
        super(symbol, currentPrice);
        this.exchange = exchange;
    }

    public String getExchange() {
        return exchange;
    }
}