package main;

public class ItemCollection {
    final Item[] itemList;

    public ItemCollection(Item[] itemList) {
        this.itemList = itemList;
    }

    public void updateAllItemsQuality() {
        for (Item item : itemList) {
            item.updateQuality();
        }
    }
    public Item[] itemList() {
        return itemList;
    }
}