package main.customer;

import main.customer.balance.Balance;
import main.menu.Menu;
import main.customer.bag.Bag;
import main.menu.toBuy.ToBuy;
import main.menu.cart.Cart;

import java.util.ArrayList;

public class Customer {
    private Balance balance;
    private Bag bag;

    public Customer(Balance balance, Bag bag) {
        this.balance = balance;
        this.bag = bag;
    }

    public void buyItem(Cart cart, Menu menu) {
        for (ToBuy toBuy : cart.getToBuyList()) {
            cart.putItems(toBuy.getName(), toBuy.getAmount(), menu);
        }
        int totalPrice = cart.getTotalPrice();
        balance.payFor(totalPrice);

        ArrayList<ToBuy> purchasedItem = menu.offerItem(cart);
        this.bag.putItem(purchasedItem);
    }

    public void printItemsInBag() {
        System.out.println("가방 속 물품: " + bag.getItemList());
    }
}
