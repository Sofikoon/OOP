package main;

public class Quality {
    private int qualityValue;

    public Quality(int qualityValue) {
        this.qualityValue = qualityValue;
    }

    public void increase() {
        if (qualityValue < 50) {
            qualityValue++;
        }
    }

    public void decrease() {
        if (qualityValue > 0) {
            qualityValue--;
        }
    }
    public int getValue() {
        return qualityValue;
    }
}