package docondev;

import java.security.InvalidParameterException;

public class Greed {
    public Integer score(Integer[] diceValues) {
        Rolls rolls = new Rolls(diceValues);
        if (rolls.getFirstDigit() <1 || rolls.getFirstDigit() >6) throw new InvalidParameterException();
        if (rolls.isaTriple()) return rolls.scoreTriple();
        return scoreSingle(rolls);
    }

    private int scoreSingle(Rolls rolls) {
        if (rolls.getFirstDigit() ==1) return 100;
        if (rolls.getFirstDigit() ==5) return 50;
        return 0;
    }

}
