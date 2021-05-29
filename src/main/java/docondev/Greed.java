package docondev;

import java.security.InvalidParameterException;

public class Greed {
    public Integer score(Throws aThrows) {
        Integer firstDigit = aThrows.getValue()[0];
        if (firstDigit <1 || firstDigit >6) throw new InvalidParameterException();
        if (isaTriple(aThrows.getValue())) return scoreTriple(aThrows.getValue());
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
