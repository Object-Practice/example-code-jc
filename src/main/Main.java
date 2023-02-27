package main;

import main.customer.Customer;
import main.customer.bag.Bag;
import main.customer.balance.Balance;
import main.customer.balance.BalanceFactory;
import main.menu.Menu;
import main.menu.itemManager.*;

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
        String toBuy = "메로나"; // Todo Cart도 넣기
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