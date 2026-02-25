package com.example.portfolio;

import java.util.*;

public final class Account {

    private final Map<String, Position> positions = new HashMap<>();
    private final AccountProvider provider;
    private final String customProviderName;

    public Account(AccountProvider provider) {
        this(provider, null);
    }

    public Account(AccountProvider provider, String customProviderName) {
        this.provider = Objects.requireNonNull(provider, "provider must not be null");
        this.customProviderName = customProviderName;
    }

    public AccountProvider getProvider() {
        return provider;
    }

    public String getProviderName() {
        if (provider == AccountProvider.OTHER && customProviderName != null) {
            return customProviderName;
        }
        return provider.name();
    }

    private Collection<Position> getPositions() {
        return Collections.unmodifiableCollection(positions.values());
    }

    public Position getPosition(String symbol) {
        return positions.get(symbol);
    }

    public void addOrUpdatePosition(Position p) {
        Objects.requireNonNull(p);
        String symbol = p.getSymbol();
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