package docondev;

import java.util.List;

class DiceSet {
    private final List<Die> dieList;

    DiceSet(List<Die> list) {
        this.dieList = list;
    }

    public static DiceSet createDiceSet(List<Die> list) {
        switch(list.size()) {
            case 2:
                return new DoubleDiceSet(list);
            case 3:
                return new TripleDiceSet(list);
            case 4:
                return new QuadDiceSet(list);
            case 5:
                return new QuintDiceSet(list);
            case 6:
                return new SextDiceSet(list);
            default:
                return new SingleDiceSet(list);
        }
    }

    public int size() {
        return dieList.size();
    }

    public Integer getValue() {
        return dieList.get(0).getValue();
    }

}
