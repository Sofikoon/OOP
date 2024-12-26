package main;

public class SellIn {
    private int daysRemaining;

    public SellIn(int daysRemaining) {
        this.daysRemaining = daysRemaining;
    }

    public int getValue() {
        return daysRemaining;
    }

    public void decrement() {
        daysRemaining--;
    }
}
