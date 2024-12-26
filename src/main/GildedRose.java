package main;

public class GildedRose {
    public final Items items;

    public GildedRose(Item[] items) {
        this.items = new Items(items);
    }

    public void updateQuality() {
        items.updateAll();
    }
}