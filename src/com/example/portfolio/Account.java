package com.example.portfolio;

<<<<<<< HEAD
// Canonical Account moved to src/com/example/portfolio/Account.java

import java.util.*;

public final class Account {
    private final String id;                   
    private final Map<String, Position> positions = new HashMap<>();

    public Account(String id) {
        this.id = Objects.requireNonNull(id);
    }

    public String getId() {
        return id;
=======
public class Account {
    private final User user;

    public Account(User user) {
        this.user = user;
    }

    public String getName() {
        return this.user.getUsername();
>>>>>>> a926a3a858cd77abbe06dc10637293053efc4ad4
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