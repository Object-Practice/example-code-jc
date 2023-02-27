package main.menu.cart;

import main.menu.Menu;
import main.menu.toBuy.ToBuy;

import java.util.ArrayList;

public class Cart {
    private ArrayList<ToBuy> ToBuyList;

    public Cart() {
        this.ToBuyList = new ArrayList<ToBuy>();
    }

    public void putItems(String nameToBuy, int amountToBuy, Menu menu) {
        ToBuy toBuy = new ToBuy(nameToBuy, amountToBuy);
        if (menu.hasItem(toBuy)) {
            this.ToBuyList.add(toBuy);
            menu.decreaseStockOf(toBuy);
        } else System.out.println("재고가 없거나 없는 아이템입니다.");
    }

    public ArrayList<ToBuy> getToBuyList() {
        return this.ToBuyList;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (ToBuy toBuy : this.ToBuyList) {
            totalPrice += toBuy.getAmount();
        }
        return totalPrice;
    }

    public void clearToBuyList() {
        this.ToBuyList = null;
    }
}
