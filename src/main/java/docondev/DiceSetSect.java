package docondev;

public class DiceSetSect extends DiceSet {
    public DiceSetSect(Integer[] value) {
        super(value);
    }

    @Override
    int score() {
        return scoreTriple() * 8;
    }
}
