package docondev;

import java.security.InvalidParameterException;

public class Greed {
    public Integer score(Rolls rolls) {
        Integer firstDigit = rolls.getFirstDigit();
        if (firstDigit <1 || firstDigit >6) throw new InvalidParameterException();
        if (rolls.isaTriple()) return rolls.scoreTriple();
        if (firstDigit ==1) return 100;
        if (firstDigit ==5) return 50;
        return 0;
    }

}
