package docondev;

import java.util.List;

class DiceSet {
    private final List<Die> dieList;

    DiceSet(List<Die> list) {
        this.dieList = list;
    }

    public static DiceSet createDiceSet(List<Die> list) {
        return new DiceSet(list);
    }

    public int size() {
        return dieList.size();
    }

    public Integer getValue() {
        return dieList.get(0).getValue();
    }

}
