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
        switch(value.length) {
            case 1:
                if (baseDigit == 1) return 100;
                if (baseDigit == 5) return 50;
                return 0;
            case 3:
                return scoreTriple();
            case 4:
                return scoreTriple() * 2;
            case 5:
                return scoreTriple() * 4;
        }
        return -1;
    }

    private int scoreTriple() {
        if (baseDigit ==1) return 1000;
        return baseDigit * 100;
    }

    private void confirmValidRolls() {
        if (baseDigit <1 || baseDigit >6) throw new InvalidParameterException();
    }
}
