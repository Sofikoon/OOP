package main;

public class GildedRose {
    public final ItemCollection itemCollection;

    public GildedRose(Item[] items) {
        this.itemCollection = new ItemCollection(items);
    }

    public void updateQuality() {
        ItemCollectionUpdater itemCollectionUpdater = new ItemCollectionUpdater(itemCollection);
        itemCollectionUpdater.updateAllItemsQuality();
    }
}