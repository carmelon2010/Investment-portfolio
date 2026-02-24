package com.example.portfolio;

public class Account {
    private final User user;

    public Account(User user) {
        this.user = user;
    }

    public String getName() {
        return this.user.getUsername();
    }
}

