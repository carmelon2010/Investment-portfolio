public class Position {
    private float originalPrice;
    private int quantity;
    private Stock stock;

    public Position(float originalPrice, int quantity, Stock stock) {
        this.originalPrice = originalPrice;
        this.quantity = quantity;
        this.stock = stock;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }
    public float getCurrentPrice() {
        return stock.getCurrentPrice();
    }
    public int getQuantity() {
        return quantity;
    }
    public Stock getStock() {
        return stock;
    }
    public float getTotalValue() {
        return quantity * stock.getCurrentPrice();
    }
    public float getProfit() {
        return quantity * (stock.getCurrentPrice() - originalPrice);
    }
    public float getProfitPercentage() {
        return (stock.getCurrentPrice() - originalPrice) / originalPrice * 100;
    }
}