package docondev;

public class DiceSetSingle extends DiceSet {
    public DiceSetSingle(Integer[] value) {
        super(value);
    }

    @Override
    int score() {
        if (baseDigit() == 1) return 100;
        if (baseDigit() == 5) return 50;
        return 0;
    }
}
