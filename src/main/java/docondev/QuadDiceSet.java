package docondev;

import java.util.List;

public class QuadDiceSet extends DiceSet {
    public QuadDiceSet(List<Die> list) {
        super(list);
    }

    @Override
    Integer scoreSet() {
        return 2 * scoreTriple(getValue());
    }
}
