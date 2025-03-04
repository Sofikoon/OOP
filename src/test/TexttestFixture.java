package test;

import main.GildedRose;
import main.Item;
import main.Quality;
import main.SellIn;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", new SellIn(10), new Quality(20)), //
                new Item("Aged Brie", new SellIn(2), new Quality(0)), //
                new Item("Elixir of the Mongoose", new SellIn(5), new Quality(7)), //
                new Item("Sulfuras, Hand of Ragnaros", new SellIn(0), new Quality(80)), //
                new Item("Sulfuras, Hand of Ragnaros", new SellIn(-1), new Quality(80)),
                new Item("Backstage passes to a TAFKAL80ETC concert", new SellIn(15), new Quality(20)),
                new Item("Backstage passes to a TAFKAL80ETC concert", new SellIn(10), new Quality(49)),
                new Item("Backstage passes to a TAFKAL80ETC concert", new SellIn(5), new Quality(49)),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", new SellIn(3), new Quality(6)) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }
}