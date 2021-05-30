package docondev;

public class DiceSetTriple extends DiceSet {
    public DiceSetTriple(Integer[] value) {
        super(value);
    }

    @Override
    int score() {
        return scoreTriple();
    }
}
