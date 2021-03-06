package docondev;

import java.util.List;

public class SingleDiceSet extends DiceSet {
    public SingleDiceSet(List<Die> list) {
        super(list);
    }

    @Override
    Integer scoreSet() {
        return scoreSingle(getValue());
    }

}
