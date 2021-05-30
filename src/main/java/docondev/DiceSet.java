package docondev;

public abstract class DiceSet {
    private Integer[] value;

    public DiceSet(Integer[] value) {
        this.value = value;
    }

    public DiceSet getSet() {
        if (count() == 1) return new DiceSetSingle(value);
        if (count() == 3) return new DiceSetTriple(value);
        if (count() == 3) return new DiceSetQuad(value);
        return this;
    }

    public int count() {
        return value.length;
    }

    Integer baseDigit() {
        return value[0];
    }

    abstract int score();

    int scoreTriple() {
        if (baseDigit() ==1) return 1000;
        return baseDigit() * 100;
    }
}
