package main;

public class Items {
    private final Item[] items;

    public Items(Item[] items) {
        this.items = items;
    }

    public void updateAll() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        boolean isSpecial = isSpecialItem(item);
        if (isSpecial) {
            updateSpecialItem(item);
            return;
        }
        Quality quality = item.getQuality();
        quality.decrease();

        if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
            SellIn sellIn = item.getSellIn();
            sellIn.decrement();
        }

        if (item.getSellIn().getValue() < 0) {
            handleExpiredItem(item);
        }
    }

    private boolean isSpecialItem(Item item) {
        String name = item.getName();
        return name.equals("Aged Brie") || name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSpecialItem(Item item) {
        Quality quality = item.getQuality();
        quality.increase();

        if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQualityForBackstagePass(item);
        }
    }

    private void increaseQualityForBackstagePass(Item item) {
        SellIn sellIn = item.getSellIn();
        if (sellIn.getValue() < 11) {
            Quality quality = item.getQuality();
            quality.increase();
        }
        if (sellIn.getValue() < 6) {
            Quality quality = item.getQuality();
            quality.increase();
        }
    }

    private void handleExpiredItem(Item item) {
        String name = item.getName();
        if (name.equals("Aged Brie")) {
            Quality quality = item.getQuality();
            quality.increase();
            return;
        }

        if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            Quality quality = item.getQuality();
            quality.decrease();
            return;
        }

        if (item.getQuality().getValue() > 0 && !name.equals("Sulfuras, Hand of Ragnaros")) {
            Quality quality = item.getQuality();
            quality.decrease();
        }
    }

    public Item[] getItems() {
        return items;
    }
}