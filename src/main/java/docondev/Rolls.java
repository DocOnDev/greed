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

    int score() {
        if (isaTriple()) return scoreTriple();
        if (isaQuad()) return scoreQuad();
        if (isaQuint()) return scoreQuint();
        return scoreSingle();
    }

    private boolean isaTriple() {
        return value.length == 3;
    }

    private int scoreTriple() {
        if (baseDigit ==1) return 1000;
        return baseDigit * 100;
    }

    private boolean isaQuad() {
        return value.length == 4;
    }

    private int scoreQuad() {
        return scoreTriple() * 2;
    }

    private boolean isaQuint() {
        return value.length == 5;
    }

    private int scoreQuint() {
        return scoreTriple() * 4;
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
