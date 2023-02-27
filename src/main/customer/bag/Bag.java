package main.customer.bag;

import main.menu.toBuy.ToBuy;

import java.util.ArrayList;

public class Bag {
    ArrayList<ToBuy> purchasedItemList;

    public Bag() {
        this.purchasedItemList = new ArrayList<ToBuy>();
    }

    public void putItem(ArrayList<ToBuy> purchasedItem) {
        this.purchasedItemList.addAll(purchasedItem);
    }

    public ArrayList<ToBuy> getItemList() {
        return this.purchasedItemList;
    }
}
