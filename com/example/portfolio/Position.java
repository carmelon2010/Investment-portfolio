package com.example.portfolio;

public class Position {
    private final float originalPrice;
    private final int quantity;
    private final FinancialAsset asset;

    public Position(float originalPrice, int quantity, FinancialAsset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset must not be null");
        }
        if (!Float.isFinite(originalPrice)) {
            throw new IllegalArgumentException("originalPrice must be a finite number");
        }
        this.originalPrice = originalPrice;
        this.quantity = quantity;
        this.asset = asset;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public FinancialAsset getAsset() {
        return asset;
    }

    public float getCurrentAssetPrice() {
        float current = asset.getCurrentPrice();
        if (!Float.isFinite(current)) {
            throw new IllegalStateException("Current asset price is not finite for symbol: " + getSymbol());
        }
        return current;
    }

    public String getSymbol() {
        return asset.getSymbol();
    }

    public boolean isLong() {
        return quantity > 0;
    }

    public boolean isShort() {
        return quantity < 0;
    }

    public float getTotalValue() {
        if (quantity == 0) return 0.0f;
        return quantity * getCurrentAssetPrice();
    }

    public float getCostBasis() {
        if (quantity == 0) return 0.0f;
        return quantity * originalPrice;
    }

    public float getProfit() {
        if (quantity == 0) return 0.0f;
        return quantity * (getCurrentAssetPrice() - originalPrice);
    }

    public float getProfitPercentage() {
        if (quantity == 0) return 0.0f;
        float denom = Math.abs(getCostBasis());
        if (!Float.isFinite(denom) || denom == 0.0f) return 0.0f;
        return (getProfit() / denom) * 100.0f;
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