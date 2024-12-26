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
        if (isSpecialItem(item)) {
            updateSpecialItem(item);
            return;
        }
        item.getQuality().decrease();
        if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
            item.getSellIn().decrement();
        }
        if (item.getSellIn().getValue() < 0) {
            handleExpiredItem(item);
        }
    }
    private boolean isSpecialItem(Item item) {
        return item.getName().equals("Aged Brie") || item.getName().equals("Backstage passes to a TAFKAL80ETC concert");
    }
    private void updateSpecialItem(Item item) {
        item.getQuality().increase();
        if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQualityForBackstagePass(item);
        }
    }
    private void increaseQualityForBackstagePass(Item item) {
        if (item.getSellIn().getValue() < 11) {
            item.getQuality().increase();
        }
        if (item.getSellIn().getValue() < 6) {
            item.getQuality().increase();
        }
    }
    private void handleExpiredItem(Item item) {
        if (item.getName().equals("Aged Brie")) {
            item.getQuality().increase();
            return;
        }
        if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.getQuality().decrease();
            return;
        }
        if (item.getQuality().getValue() > 0 && !item.getName().equals("Sulfuras, Hand of Ragnaros")) {
            item.getQuality().decrease();
        }
    }
    public Item[] getItems() {
        return items;
    }
}