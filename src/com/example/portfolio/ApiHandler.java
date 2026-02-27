package com.example.portfolio;

public class ApiHandler {
    public static void main(String[] args) {
        Stock s = Stock.getInstance("AAPL", 170.0f);
        s.refreshPrice();
        System.out.println("Current price of " + s.getSymbol() + ": " + s.getCurrentPrice());
    }
}

