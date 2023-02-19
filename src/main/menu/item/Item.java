package main.menu.item;

public abstract class Item {
    protected String name;
    protected int price;
    protected int stock;

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void releaseStock(int amount) {
        stock -= amount;
    }
}
