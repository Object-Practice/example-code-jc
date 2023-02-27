package main;

import main.customer.Customer;
import main.customer.bag.Bag;
import main.customer.balance.Balance;
import main.customer.balance.BalanceFactory;
import main.menu.Menu;
import main.menu.itemManager.*;
import main.menu.cart.Cart;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Menu Input
        ArrayList<ItemManager> itemManagers = new ArrayList<ItemManager>();
        itemManagers.add(new IceCreamManager("메로나", 800, 3));
        itemManagers.add(new SnackManager("신당동 떡볶이", 2000, 1));
        itemManagers.add(new SojuManager("메로나", 800, 3));
        Menu menu = new Menu(itemManagers);

        // Customer Input -> 이 부분도 나중에 떼기
        int balanceQuantity = 3000;
        String nameToBuy1 = "메로나";
        int amountToBuy1 = 2;
        String nameToBuy2 = "신당동 떡볶이";
        int amountToBuy2 = 1;
        String payment = "cash";

        // Cart
        Cart cart = new Cart();
        cart.putItems(nameToBuy1, amountToBuy1, menu);
        cart.putItems(nameToBuy2, amountToBuy2, menu);

        // Customer
        Bag bag = new Bag();
        BalanceFactory balanceFactory = new BalanceFactory(payment, balanceQuantity);
        Balance balance = balanceFactory.createBalance();
        Customer customer = new Customer(balance, bag);
        customer.buyItem(cart, menu);
        // 재고량 보여주는 로직 ㄱㄱ
        customer.printItemsInBag();
    }
}