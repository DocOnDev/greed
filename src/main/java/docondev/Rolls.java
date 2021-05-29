package docondev;

import java.security.InvalidParameterException;

public class Rolls {
    private final Integer[] value;

    public Rolls(Integer[] value) {
        this.value = value;
        confirmValidRolls();
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

    private void confirmValidRolls() {
        if (getFirstDigit() <1 || getFirstDigit() >6) throw new InvalidParameterException();
    }

    int scoreSingle() {
        if (getFirstDigit() ==1) return 100;
        if (getFirstDigit() ==5) return 50;
        return 0;
    }
}
