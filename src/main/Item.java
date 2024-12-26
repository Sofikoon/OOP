package main;

public class Item {
    final String itemName;
    final ItemAttributes attributes;

    public Item(String itemName, SellIn sellInDays, Quality itemQuality) {
        this.itemName = itemName;
        this.attributes = new ItemAttributes(sellInDays, itemQuality);
    }

    public void updateQuality() {
        ItemUpdater itemUpdater = new ItemUpdater(this);
        itemUpdater.updateQuality();
    }
    public void decrementSellIn() {
        attributes.decrementSellIn();
    }
    public void increaseQuality() {
        attributes.increaseQuality();
    }
    public void decreaseQuality() {
        attributes.decreaseQuality();
    }

    public boolean isSpecial() {
        return itemName.equals("Aged Brie") || itemName.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public String describe() {
        return itemName + ", " + attributes.getSellInDaysValue() + ", " + attributes.getItemQualityValue();
    }
    public int getSellInDaysValue() {
        return attributes.getSellInDaysValue();
    }
    public int getItemQualityValue() {
        return attributes.getItemQualityValue();
    }
    public String itemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return itemName + ", " + attributes.getSellInDaysValue() + ", " + attributes.getItemQualityValue();
    }
}