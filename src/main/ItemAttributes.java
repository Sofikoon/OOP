package main;

public class ItemAttributes {
    final SellIn sellInDays;
    private final Quality itemQuality;

    public ItemAttributes(SellIn sellInDays, Quality itemQuality) {
        this.sellInDays = sellInDays;
        this.itemQuality = itemQuality;
    }

    public void decrementSellIn() {
        sellInDays.decrement();
    }

    public void increaseQuality() {
        itemQuality.increase();
    }
    public void decreaseQuality() {
        itemQuality.decrease();
    }
    public int getSellInDaysValue() {
        return sellInDays.getValue();
    }
    public int getItemQualityValue() {
        return itemQuality.getValue();
    }
}