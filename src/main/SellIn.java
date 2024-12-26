package main;

public class SellIn {
    private int daysRemaining;

    public SellIn(int daysRemaining) {
        this.daysRemaining = daysRemaining;
    }

    public void decrement() {
        daysRemaining--;
    }
    public boolean isExpired() {
        return daysRemaining < 0;
    }
    public int getValue() {
        return daysRemaining;
    }
}