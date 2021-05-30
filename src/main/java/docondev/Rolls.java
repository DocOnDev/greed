package docondev;

import java.security.InvalidParameterException;

public class Rolls {
    private final DiceSet dice;

    public Rolls(DiceSet diceSet) {
        this.dice = diceSet;
        confirmValidRolls();
    }

    int score() {
        switch(dice.count()) {
            case 1:
            case 3:
                return dice.score();
            case 4:
                return dice.scoreTriple() * 2;
            case 5:
                return dice.scoreTriple() * 4;
        }
        return -1;
    }

    private void confirmValidRolls() {
        if (dice.baseDigit() <1 || dice.baseDigit() >6) throw new InvalidParameterException();
    }
}
