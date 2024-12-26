package main;

public class Items {
    private final Item[] itemList;

    public Items(Item[] itemList) {
        this.itemList = itemList;
    }

    public void updateAllItemsQuality() {
        for (Item item : itemList) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        boolean isSpecialItem = isSpecialItem(item);

        if (isSpecialItem) {
            updateSpecialItemQuality(item);
            return;
        }

        Quality itemQuality = item.getItemQuality();
        itemQuality.decrease();

        if (!item.getItemName().equals("Sulfuras, Hand of Ragnaros")) {
            SellIn sellInDays = item.getSellInDays();
            sellInDays.decrement();
        }

        if (item.getSellInDays().getValue() < 0) {
            handleExpiredItemQuality(item);
        }
    }

    private boolean isSpecialItem(Item item) {
        String name = item.getItemName();
        return name.equals("Aged Brie") || name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSpecialItemQuality(Item item) {
        Quality itemQuality = item.getItemQuality();
        itemQuality.increase();

        if (item.getItemName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQualityForBackstagePass(item);
        }
    }

    private void increaseQualityForBackstagePass(Item item) {
        SellIn sellInDays = item.getSellInDays();

        if (sellInDays.getValue() < 11) {
            Quality itemQuality = item.getItemQuality();
            itemQuality.increase();
        }
        if (sellInDays.getValue() < 6) {
            Quality itemQuality = item.getItemQuality();
            itemQuality.increase();
        }
    }

    private void handleExpiredItemQuality(Item item) {
        String itemName = item.getItemName();

        if (itemName.equals("Aged Brie")) {
            Quality itemQuality = item.getItemQuality();
            itemQuality.increase();
            return;
        }

        if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            Quality itemQuality = item.getItemQuality();
            itemQuality.decrease();
            return;
        }

        if (item.getItemQuality().getValue() > 0 && !itemName.equals("Sulfuras, Hand of Ragnaros")) {
            Quality itemQuality = item.getItemQuality();
            itemQuality.decrease();
        }
    }

    public Item[] getItemList() {
        return itemList;
    }
}