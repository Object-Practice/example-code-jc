package main.customer.balance;

// Todo) 나중에 구매 로그 기능 추가
public abstract class Balance {
    protected int quantity;

    public Balance(int quantity) {
        this.quantity = quantity;
    }

    public void payFor(int price) {
        quantity -= price;
    }
}
