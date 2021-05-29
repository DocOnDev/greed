package docondev;

public class Rolls {
    private final Integer[] value;

    public Rolls(Integer[] value) {
        this.value = value;
    }

    public Integer[] getValue() {
        return value;
    }

    Integer getFirstDigit() {
        return getValue()[0];
    }

    boolean isaTriple() {
        return getValue().length == 3;
    }

    int scoreTriple() {
        if (getFirstDigit()==1) return 1000;
        return getFirstDigit() * 100;
    }
}
