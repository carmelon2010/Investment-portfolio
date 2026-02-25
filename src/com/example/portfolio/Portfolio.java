package com.example.portfolio;

import java.util.*;

public final class Portfolio {
    private final Set<Account> accounts = new HashSet<>();

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public Set<Account> getAccounts() {
        return Set.copyOf(accounts);
    }
}

