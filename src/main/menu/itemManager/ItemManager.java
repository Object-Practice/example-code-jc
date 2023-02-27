package main.menu.itemManager;

public abstract class ItemManager {
    protected String name;
    protected int price;
    protected int stock;

    public ItemManager(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock(int amount) {
        stock -= amount;
    }
}
