package main;

import main.customer.Customer;
import main.customer.bag.Bag;
import main.customer.balance.*;
import main.menu.Menu;
import main.menu.item.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Menu Input -> Todo) 문자열 split 하는 법 배운 후 작업하기
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new IceCream("메로나", 800, 3));
        items.add(new Snack("신당동 떡볶이", 2000, 1));
        items.add(new Soju("메로나", 800, 3));
        Menu menu = new Menu(items);

        // Customer Input -> 이 부분도 나중에 떼기
        int balanceQuantity = 3000;
        String toBuy = "메로나";
        String payment = "cash";
        Balance balance = null; // 현금 디폴트
        if (payment == "card") balance = new CardBalance(balanceQuantity);
        else if (payment == "cash") balance = new CashBalance(balanceQuantity);
        else {
            System.out.println("유효하지 않은 결제 수단입니다.");
            return;
        }

        // Customer
        Bag bag = new Bag();
        Customer customer = new Customer(menu, balance, bag);
        customer.buyItem(toBuy);
        System.out.println("재고량: " + menu.getItemStock(toBuy));
        customer.printItemsInBag();
    }
}