package main.customer.balance;

import main.customer.balance.*;

public class BalanceFactory {
    private Balance balance;

    public BalanceFactory(String payment, int balanceQuantity) {
        if (payment == "card") this.balance = new CardBalance(balanceQuantity);
        else if (payment == "cash") this.balance = new CashBalance(balanceQuantity);
        else {
            System.out.println("유효하지 않은 결제 수단입니다.");
            this.balance = null;
        }
    }

    public Balance createBalance() {
        return this.balance;
    }
}
