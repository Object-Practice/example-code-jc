package main.customer;

import main.customer.balance.Balance;
import main.menu.Menu;
import main.customer.bag.Bag;
import main.menu.item.Item;

import java.util.ArrayList;

public class Customer {
    private Menu menu;
    private Balance balance;
    private Bag bag;

    // [?] Menu가 아닌 Service로 만들어 주면 조금 더 문맥에 독립적이지 않을까?
    public Customer(Menu menu, Balance balance, Bag bag) {
        this.menu = menu;
        this.balance = balance;
        this.bag = bag;
    }

    public void buyItem(String toBuy) {
        if (!this.menu.hasItem(toBuy)) {
            System.out.println("존재하지 않는 상품입니다.");
            return;
        }

        int price = this.menu.getItemPrice(toBuy);
        balance.payFor(price);
        String purchasedItem = menu.offerItem(toBuy);
        this.bag.putItem(purchasedItem);
    }

    public void printItemsInBag() {
        System.out.println("가방 속 물품: " + bag.getItemList());
    }
}
