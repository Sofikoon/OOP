package main;

public class ItemUpdater {
    private final Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    public void updateQuality() {
        if (item.isSpecial()) {
            updateSpecialItemQuality();
            return;
        }
        updateRegularItemQuality();
    }

    private void updateRegularItemQuality() {
        item.decreaseQuality();

        if (!item.itemName.equals("Sulfuras, Hand of Ragnaros")) {
            item.decrementSellIn();
        }

        if (item.attributes.sellInDays.isExpired()) {
            handleExpiredItemQuality();
        }
    }

    private void updateSpecialItemQuality() {
        item.increaseQuality();

        if (item.itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQualityForBackstagePass();
        }
    }

    private void increaseQualityForBackstagePass() {
        int sellInDaysValue = item.getSellInDaysValue();

        if (sellInDaysValue < 11) {
            item.increaseQuality();
        }
        if (sellInDaysValue < 6) {
            item.increaseQuality();
        }
    }

    private void handleExpiredItemQuality() {
        String itemName = item.itemName;

        if (itemName.equals("Aged Brie")) {
            item.increaseQuality();
            return;
        }

        if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.decreaseQuality();
            return;
        }

        if (item.getItemQualityValue() > 0 && !itemName.equals("Sulfuras, Hand of Ragnaros")) {
            item.decreaseQuality();
        }
    }
}