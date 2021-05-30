package docondev;

public class DiceSet {
    private final Integer[] value;

    public DiceSet(Integer[] value) {
        this.value = value;
    }

    public int count() {
        return value.length;
    }

    Integer baseDigit() {
        return value[0];
    }
}
