package main.customer.bag;

import java.util.ArrayList;

public class Bag {
    ArrayList<String> purchasedItemList;

    public Bag() {
        this.purchasedItemList = new ArrayList<String>();
    }

    public void putItem(String purchasedItem) {
        this.purchasedItemList.add(purchasedItem);
    }

    public ArrayList<String> getItemList() {
        return this.purchasedItemList;
    }
}
