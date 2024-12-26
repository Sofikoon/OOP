package main;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (isSpecialItem(item)) {
            updateSpecialItem(item);
            return;
        }
        decreaseQuality(item);

        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }

        if (item.sellIn < 0) {
            handleExpiredItem(item);
        }
    }

    private boolean isSpecialItem(Item item) {
        return item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSpecialItem(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
        }

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQualityForBackstagePass(item);
        }
    }

    private void increaseQualityForBackstagePass(Item item) {
        if (item.sellIn < 11 && item.quality < 50) {
            increaseQuality(item);
        }
        if (item.sellIn < 6 && item.quality < 50) {
            increaseQuality(item);
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.name.equals("Aged Brie")) {
            if (item.quality < 50) {
                increaseQuality(item);
            }
            return;
        }
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
            return;
        }
        if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            decreaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        item.quality++;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}