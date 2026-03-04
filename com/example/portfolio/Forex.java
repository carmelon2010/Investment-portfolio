package com.example.portfolio;

public final class Forex extends FinancialAsset {
    private final String exchange;

    public Forex(String symbol, float currentPrice, String exchange) {
        super(symbol, currentPrice);
        this.exchange = exchange;
    }

    public String getExchange() {
        return exchange;
    }
}