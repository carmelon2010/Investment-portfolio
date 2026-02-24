package com.example.portfolio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Portfolio {
    private final List<Account> accounts = new ArrayList<>();
    public void addAccount(Account a) { accounts.add(a); }
    public List<Account> accounts() { return Collections.unmodifiableList(accounts); }
}

