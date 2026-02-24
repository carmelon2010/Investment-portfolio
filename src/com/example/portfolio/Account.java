package com.example.portfolio;

// Canonical Account moved to src/com/example/portfolio/Account.java

import java.util.*;

public final class Account {

    private String Exchange;
    private final String id;                   
    private final Map<String, Position> positions = new HashMap<>();

    public Account(String id) {
        this.id = Objects.requireNonNull(id);
    }

    public String getExchange() {
        return Exchange;
    }

    public String getId() {
        return id;
    }

    public Collection<Position> getPositions() {
        return Collections.unmodifiableCollection(positions.values());
    }

    public Position getPosition(String symbol) {
        return positions.get(symbol);
    }

    public void addOrUpdatePosition(Position p) {
        Objects.requireNonNull(p);
        String symbol = p.getStock().getSymbol();
        positions.put(symbol, p);
    }

    public boolean removePosition(String symbol) {
        return positions.remove(symbol) != null;
    }

    public float getTotalValue() {
        float sum = 0f;
        for (Position p : positions.values()) sum += p.getTotalValue();
        return sum;
    }

    public float getTotalProfit() {
        float sum = 0f;
        for (Position p : positions.values()) sum += p.getProfit();
        return sum;
    }

    public float getTotalProfitPercentage() {
        float cost = 0f;
        float value = 0f;
        for (Position p : positions.values()) {
            cost += p.getQuantity() * p.getOriginalPrice();
            value += p.getTotalValue();
        }
        if (cost == 0f) return 0f;
        return (value - cost) / cost * 100f;
    }
}