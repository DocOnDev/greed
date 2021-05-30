package docondev;

public class Rolls {
    private final DiceSet dice;

    public Rolls(DiceSet diceSet) {
        this.dice = diceSet;
    }

    int score() {
        return dice.score();
    }

}
