package main.menu.toBuy;

public class ToBuy {
    private String name;
    private int amount;

    public ToBuy(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.amount;
    }
}
