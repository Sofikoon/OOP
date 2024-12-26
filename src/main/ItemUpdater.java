package main;

public class ItemUpdater {
    private final Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    public void updateQuality() {
        if (isSpecialItem(item)) {
            updateSpecialItemQuality();
        } else {
            updateRegularItemQuality();
        }
    }

    private boolean isSpecialItem(Item item) {
        String name = item.getItemName();
        return name.equals("Aged Brie") || name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateRegularItemQuality() {
        Quality itemQuality = item.getItemQuality();
        itemQuality.decrease();

        if (!item.getItemName().equals("Sulfuras, Hand of Ragnaros")) {
            item.getSellInDays().decrement();
        }

        if (item.getSellInDays().getValue() < 0) {
            handleExpiredItemQuality();
        }
    }

    private void updateSpecialItemQuality() {
        Quality itemQuality = item.getItemQuality();
        itemQuality.increase();

        if (item.getItemName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQualityForBackstagePass();
        }
    }

    private void increaseQualityForBackstagePass() {
        SellIn sellInDays = item.getSellInDays();

        if (sellInDays.getValue() < 11) {
            item.getItemQuality().increase();
        }
        if (sellInDays.getValue() < 6) {
            item.getItemQuality().increase();
        }
    }

    private void handleExpiredItemQuality() {
        String itemName = item.getItemName();

        if (itemName.equals("Aged Brie")) {
            item.getItemQuality().increase();
            return;
        }

        if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.getItemQuality().decrease();
            return;
        }

        if (item.getItemQuality().getValue() > 0 && !itemName.equals("Sulfuras, Hand of Ragnaros")) {
            item.getItemQuality().decrease();
        }
    }
}