package main;
public class SellIn {
    private int value;
    public SellIn(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public void decrement() {
        value--;
    }
}
