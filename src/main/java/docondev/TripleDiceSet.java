package docondev;

import java.util.List;

public class TripleDiceSet extends DiceSet {
    public TripleDiceSet(List<Die> list) {
        super(list);
    }

    @Override
    Integer scoreSet() {
        Integer dieValue = getValue();
        return scoreTriple(dieValue);
    }

}
