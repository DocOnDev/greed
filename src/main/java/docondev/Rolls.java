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
                if (dice.baseDigit() == 1) return 100;
                if (dice.baseDigit() == 5) return 50;
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
        if (dice.baseDigit() ==1) return 1000;
        return dice.baseDigit() * 100;
    }

    private void confirmValidRolls() {
        if (dice.baseDigit() <1 || dice.baseDigit() >6) throw new InvalidParameterException();
    }
}
