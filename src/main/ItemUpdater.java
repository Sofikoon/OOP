package main;

public class ItemUpdater {
    private final ItemCollection itemCollection;

    public ItemUpdater(ItemCollection itemCollection) {
        this.itemCollection = itemCollection;
    }

    public void updateAllItemsQuality() {
        for (Item item : itemCollection.getItems()) {
            updateItemQuality(item);
        }
    }
    @@ -81,8 +81,4 @@ private void handleExpiredItemQuality(Item item) {
        itemQuality.decrease();
    }
}
}