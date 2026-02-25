package com.example.portfolio;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class Portfolio {
    private final Set<Account> accounts = new HashSet<>();
    private final User user;

    public Portfolio(User user) {
        this.user = Objects.requireNonNull(user, "user must not be null");
    }

    public User getUser() {
        return user;
    }

    public int getUserId() {
        return user.getId();
    }

    public String getUsername() {
        return user.getUsername();
    }

    public void addAccount(Account a) {
        accounts.add(Objects.requireNonNull(a, "account must not be null"));
    }

    public boolean removeAccount(Account a) {
        return accounts.remove(a);
    }

    public void clearAccounts() {
        accounts.clear();
    }

    public Set<Account> getAccounts() {
        return Set.copyOf(accounts);
    }

    public Set<Account> findAccountByProvider(AccountProvider provider) {
        if (provider == null) return Set.of();
        return accounts.stream()
                .filter(a -> provider.equals(a.getProvider()))
                .collect(Collectors.toUnmodifiableSet());
    }

    public float getTotalValue() {
        float sum = 0f;
        for (Account a : accounts) sum += a.getTotalValue();
        return sum;
    }

    public float getTotalProfit() {
        float sum = 0f;
        for (Account a : accounts) sum += a.getTotalProfit();
        return sum;
    }

    public float getTotalProfitPercentage() {
        float totalValue = 0f;
        float totalProfit = 0f;

        for (Account a : accounts) {
            totalValue += a.getTotalValue();
            totalProfit += a.getTotalProfit();
        }

        float totalCost = totalValue - totalProfit;
        if (totalCost == 0f) return 0f;

        return (totalProfit / totalCost) * 100f;
    }
}