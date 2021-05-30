package docondev;

public class DiceSetQuint extends DiceSet {
    public DiceSetQuint(Integer[] value) {
        super(value);
    }

    @Override
    int score() {
        return scoreTriple() * 4;
    }
}
