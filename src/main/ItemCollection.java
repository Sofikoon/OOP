package main;
public class ItemCollection {
    private final Item[] itemList;
    public ItemCollection(Item[] itemList) {
        this.itemList = itemList;
    }
    public Item[] getItems() {
        return itemList;
    }
}
