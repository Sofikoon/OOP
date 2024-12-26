package main;

public class GildedRose {
    public final ItemCollection itemCollection;

    public GildedRose(Item[] items) {
        this.itemCollection = new ItemCollection(items);
    }

    public void updateQuality() {
        ItemUpdater itemUpdater = new ItemUpdater(itemCollection);
        itemUpdater.updateAllItemsQuality();
    }
}