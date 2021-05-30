package docondev;

import java.security.InvalidParameterException;

public abstract class DiceSet {
    private Integer[] value;

    public DiceSet(Integer[] value) {
        this.value = value;
        confirmValidRolls();
    }

    abstract int score();

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
