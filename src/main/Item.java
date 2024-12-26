package main;

public class Item {
    private final String itemName;
    private final ItemAttributes attributes;

    public Item(String itemName, SellIn sellInDays, Quality itemQuality) {
        this.itemName = itemName;
        this.attributes = new ItemAttributes(sellInDays, itemQuality);
    }

    public String getItemName() {
        return itemName;
    }

    public SellIn getSellInDays() {
        return attributes.getSellInDays();
    }

    public Quality getItemQuality() {
        return attributes.getItemQuality();
    }

    @Override
    public String toString() {
        return itemName + ", " + attributes.getSellInDays().getValue() + ", " + attributes.getItemQuality().getValue();
    }
}