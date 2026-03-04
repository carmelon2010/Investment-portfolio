package com.example.portfolio;

final class TestAsset extends FinancialAsset {
    TestAsset(String symbol, float currentPrice) {
        super(symbol, currentPrice);
    }

    void forcePrice(float price) {
        setCurrentPrice(price);
    }
}