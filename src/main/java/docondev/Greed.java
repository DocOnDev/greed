package docondev;

import java.security.InvalidParameterException;

public class Greed {
    public Integer score(Rolls rolls) {
        Integer firstDigit = rolls.getValue()[0];
        if (firstDigit <1 || firstDigit >6) throw new InvalidParameterException();
        if (isaTriple(rolls.getValue())) return scoreTriple(rolls.getValue());
        if (firstDigit ==1) return 100;
        if (firstDigit ==5) return 50;
        return 0;
    }

    private boolean isaTriple(Integer[] value) {
        return value.length == 3;
    }

    private int scoreTriple(Integer[] value) {
        if (value[0]==1) return 1000;
        return value[0] * 100;
    }
}
