package docondev;

import java.security.InvalidParameterException;

public abstract class DiceSet {
    private Integer[] value;

    public DiceSet(Integer[] value) {
        this.value = value;
        confirmValidRolls();
    }

    abstract int score();

    public DiceSet getSet() {
        switch(count()){
            case 1: return new DiceSetSingle(value);
            case 3: return new DiceSetTriple(value);
            case 4: return new DiceSetQuad(value);
            case 5: return new DiceSetQuint(value);
            default: return this;
        }
    }

    public int count() {
        return value.length;
    }

    Integer baseDigit() {
        return value[0];
    }

    int scoreTriple() {
        if (baseDigit() ==1) return 1000;
        return baseDigit() * 100;
    }

    void confirmValidRolls() {
        if (baseDigit() <1 || baseDigit() >6) throw new InvalidParameterException();
    }
}
