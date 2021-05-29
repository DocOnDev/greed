package docondev;

import java.security.InvalidParameterException;

public class Rolls {
    private final Integer[] value;

    public Rolls(Integer[] value) {
        this.value = value;
        confirmValidRolls();
    }

    Integer getFirstDigit() {
        return value[0];
    }

    boolean isaTriple() {
        return value.length == 3;
    }

    int score() {
        if (isaTriple()) return scoreTriple();
        return scoreSingle();
    }

    private int scoreTriple() {
        if (getFirstDigit()==1) return 1000;
        return getFirstDigit() * 100;
    }

    private int scoreSingle() {
        if (getFirstDigit() ==1) return 100;
        if (getFirstDigit() ==5) return 50;
        return 0;
    }

    private void confirmValidRolls() {
        if (getFirstDigit() <1 || getFirstDigit() >6) throw new InvalidParameterException();
    }
}
