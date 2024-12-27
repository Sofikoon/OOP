package main;

public class ItemCollectionUpdater {
    private final ItemCollection itemCollection;

    public ItemCollectionUpdater(ItemCollection itemCollection) {
        this.itemCollection = itemCollection;
    }

    public void updateAllItemsQuality() {
        for (Item item : itemCollection.itemList) {
            ItemUpdater itemUpdater = new ItemUpdater(item);
            itemUpdater.updateQuality();
        }
    }
}