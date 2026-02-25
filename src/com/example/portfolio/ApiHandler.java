package com.example.portfolio;

public class ApiHandler {
    static void main(String[] args) {
        Stock s = Stock.getInstance("AAPL", 170.0f);
        Position p = new Position(150.0f, 10, s);

        System.out.println("Got position for " + s.getSymbol());
        System.out.println("Current price: " + s.getCurrentPrice());
        System.out.println("Total value: " + p.getTotalValue());
        System.out.println("Profit: " + p.getProfit());
        System.out.printf("Profit percentage: %.2f%%%n", p.getProfitPercentage());
    }
}

