package docondev;

import java.util.List;

class DiceSet {
    private final List<Die> dieList;

    public DiceSet(List<Die> list) {
        this.dieList = list;
    }

    public int size() {
        return dieList.size();
    }

    public Integer getValue() {
        return dieList.get(0).getValue();
    }

}
