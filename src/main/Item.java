package main;

public class Item {
    private final String itemName;
    private final SellIn sellInDays;
    private final Quality itemQuality;

    public Item(String itemName, SellIn sellInDays, Quality itemQuality) {
        this.itemName = itemName;
        this.sellInDays = sellInDays;
        this.itemQuality = itemQuality;
    }

    public String getItemName() {
        return itemName;
    }

    public SellIn getSellInDays() {
        return sellInDays;
    }

    public Quality getItemQuality() {
        return itemQuality;
    }

    @Override
    public String toString() {
        return itemName + ", " + sellInDays.getValue() + ", " + itemQuality.getValue();
    }
}