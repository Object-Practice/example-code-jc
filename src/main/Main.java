package main;

import main.customer.Customer;
import main.customer.bag.Bag;
import main.customer.balance.Balance;
import main.customer.balance.BalanceFactory;
import main.menu.Menu;
import main.menu.item.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Menu Input
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new IceCream("메로나", 800, 3));
        items.add(new Snack("신당동 떡볶이", 2000, 1));
        items.add(new Soju("메로나", 800, 3));
        Menu menu = new Menu(items);

        // Customer Input -> 이 부분도 나중에 떼기
        int balanceQuantity = 3000;
        String toBuy = "메로나";
        String payment = "cash";

        // Customer
        Bag bag = new Bag();
        BalanceFactory balanceFactory = new BalanceFactory(payment, balanceQuantity);
        Balance balance = balanceFactory.createBalance();
        Customer customer = new Customer(balance, bag);
        // toBuy를 Item 타입으로 전달해주기
        customer.buyItem(toBuy, menu);
        System.out.println("재고량: " + menu.getItemStock(toBuy));
        customer.printItemsInBag();
    }
}