package docondev;

import java.security.InvalidParameterException;

public class Rolls {
    private final Integer[] value;
    private Integer baseDigit;

    public Rolls(Integer[] value) {
        this.value = value;
        baseDigit = this.value[0];
        confirmValidRolls();
    }

    boolean isaTriple() {
        return value.length == 3;
    }

    int score() {
        if (isaTriple()) return scoreTriple();
        return scoreSingle();
    }

    private int scoreTriple() {
        if (baseDigit ==1) return 1000;
        return baseDigit * 100;
    }

    private int scoreSingle() {
        if (baseDigit ==1) return 100;
        if (baseDigit ==5) return 50;
        return 0;
    }

    private void confirmValidRolls() {
        if (baseDigit <1 || baseDigit >6) throw new InvalidParameterException();
    }
}
