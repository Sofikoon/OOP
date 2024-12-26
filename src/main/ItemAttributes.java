package main;
public class ItemAttributes {
    private final SellIn sellInDays;
    private final Quality itemQuality;
    public ItemAttributes(SellIn sellInDays, Quality itemQuality) {
        this.sellInDays = sellInDays;
        this.itemQuality = itemQuality;
    }
    public SellIn getSellInDays() {
        return sellInDays;
    }
    public Quality getItemQuality() {
        return itemQuality;
    }
}