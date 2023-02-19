package main.menu;

import main.menu.item.Item;
// [?] List로 타입을 설정해야 확장성이 있나?

import java.util.ArrayList;

// Todo) 나중에 items를 보충할 수 있는 기능 추가하기
public class Menu {
    private ArrayList<Item> items;

    // Todo) toBuy를 생성자로 빼내면 좋을 듯
    public Menu(ArrayList<Item> items) {
        this.items = items;
    }

    private Item getItem(String toBuy) {
        for (Item item : this.items) if (item.getName() == toBuy) return item;
        return null;
    }

    public Boolean hasItem(String toBuy) {
        if (getItem(toBuy) != null) return true;
        return false;
    }

    public int getItemPrice(String toBuy) {
        return getItem(toBuy).getPrice();
    }

    public String offerItem(String toBuy) {
        // 깊은 복사? 얕은 복사?
        Item itemForCustomer = getItem(toBuy);
        itemForCustomer.releaseStock(1); // Todo) amount 확장하기
        return itemForCustomer.getName();
    }

    public int getItemStock(String toBuy) {
        return getItem(toBuy).getStock();
    }
}
