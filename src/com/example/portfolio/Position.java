package com.example.portfolio;

public class Position {
    private final float originalPrice;
    private final int quantity;      // can be negative (short), zero, or positive (long)
    private final Stock stock;

    public Position(float originalPrice, int quantity, Stock stock) {
        if (stock == null) {
            throw new IllegalArgumentException("stock must not be null");
        }
        if (!Float.isFinite(originalPrice)) {
            throw new IllegalArgumentException("originalPrice must be a finite number");
        }
        this.originalPrice = originalPrice;
        this.quantity = quantity;
        this.stock = stock;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public float getCurrentStockPrice() {
        float current = this.getStock().getCurrentPrice();
        if (!Float.isFinite(current)) {
            throw new IllegalStateException("Current stock price is not finite for symbol: " + getSymbol());
        }
        return current;
    }

    public String getSymbol() {
        String symbol = this.getStock().getSymbol();
        return symbol == null ? "" : symbol;
    }

    /** True when quantity > 0 (long position). */
    public boolean isLong() {
        return quantity > 0;
    }

    /** True when quantity < 0 (short position). */
    public boolean isShort() {
        return quantity < 0;
    }

    /**
     * Signed market value.
     * - Long (qty>0): positive when price is positive
     * - Short (qty<0): negative when price is positive (represents liability/short exposure)
     */
    public float getTotalValue() {
        if (quantity == 0) return 0.0f;
        return this.getQuantity() * this.getCurrentStockPrice();
    }

    /**
     * Signed cost basis (quantity * originalPrice).
     * For shorts, this is typically negative (because quantity is negative).
     */
    public float getCostBasis() {
        if (quantity == 0) return 0.0f;
        return this.getQuantity() * this.getOriginalPrice();
    }

    public float getProfit() {
        if (quantity == 0) return 0.0f;
        return this.getQuantity() * (this.getCurrentStockPrice() - this.getOriginalPrice());
    }

    /**
     * Profit percentage based on absolute cost basis to behave sensibly for shorts.
     *
     * Edge cases handled:
     * - quantity == 0 => 0%
     * - originalPrice == 0 (or cost basis == 0) => 0% (avoid division by zero / exploding %)
     */
    public float getProfitPercentage() {
        if (quantity == 0) return 0.0f;

        float basis = getCostBasis();
        float denom = Math.abs(basis);

        if (!Float.isFinite(denom) || denom == 0.0f) {
            return 0.0f;
        }

        float pnl = getProfit();
        return (pnl / denom) * 100.0f;
    }

    @Override
    public String toString() {
        return "Position{" +
                "symbol='" + getSymbol() + '\'' +
                ", quantity=" + quantity +
                ", originalPrice=" + originalPrice +
                '}';
    }
}

