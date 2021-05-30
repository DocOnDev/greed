package docondev;

public class DiceSetQuad extends DiceSet {
    public DiceSetQuad(Integer[] value) {
        super(value);
    }

    @Override
    int score() {
        return scoreTriple() * 2;
    }
}
