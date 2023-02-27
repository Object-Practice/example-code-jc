package main.menu;

import main.menu.cart.Cart;
import main.menu.itemManager.ItemManager;
import main.menu.toBuy.ToBuy;
// [?] List로 타입을 설정해야 확장성이 있나?

import java.util.ArrayList;

// Todo) 나중에 items를 보충할 수 있는 기능 추가하기
public class Menu {
    private ArrayList<ItemManager> itemManagers;

    public Menu(ArrayList<ItemManager> itemManagers) {
        this.itemManagers = itemManagers;
    }

    private ItemManager getItemManager(ToBuy toBuy) {
        for (ItemManager itemManager : this.itemManagers)
            if (itemManager.getName() == toBuy.getName()) return itemManager;
        return null;
    }

    public boolean hasItem(ToBuy toBuy) {
        ItemManager itemManager = this.getItemManager(toBuy);
        return (itemManager != null && itemManager.getStock() > 0);
    }

    public ArrayList<ToBuy> offerItem(Cart cart) {
        ArrayList<ToBuy> ToBuyList = cart.getToBuyList();
        cart.clearToBuyList();
        return ToBuyList;
    }

    public void decreaseStockOf(ToBuy toBuy) {
        ItemManager itemManagerForCustomer = this.getItemManager(toBuy);
        itemManagerForCustomer.decreaseStock(toBuy.getAmount());
    }

    public int getItemStock(ToBuy toBuy) {
        return this.getItemManager(toBuy).getStock();
    }
}
