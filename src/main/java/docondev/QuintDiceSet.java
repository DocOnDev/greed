package docondev;

import java.util.List;

public class QuintDiceSet extends DiceSet {
    public QuintDiceSet(List<Die> list) {
        super(list);
    }

    @Override
    Integer scoreSet() {
        return 4 * scoreTriple(getValue());
    }
}
