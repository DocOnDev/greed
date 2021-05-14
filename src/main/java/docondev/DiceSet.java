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

    Integer scoreSet() {
        if (size() == 1) {
            Integer die = getValue();
            if ( die == 1) return 100;
            if ( die == 5) return 50;
            return 0;
        }
        if (size() == 2) {
            Integer result = 0;
            Integer die = getValue();
            if ( die == 1) {
                result = 100;
            } else if ( die == 5) {
                result = 50;
            }
            return 2 * result;
        }
        if (size() == 3) {
            Integer dieValue = getValue();
            if (dieValue == 1) return 1000;
            return dieValue * 100;
        }
        if (size() == 4) {
            Integer result = 1000;
            Integer dieValue = getValue();
            if (dieValue != 1) {
                result = dieValue * 100;
            }
            return 2 * result;
        }
        if (size() == 5) {
            Integer result = 1000;
            Integer dieValue = getValue();
            if (dieValue != 1) {
                result = dieValue * 100;
            }
            return 4 * result;
        }
        if (size() == 6) {
            Integer result = 1000;
            Integer dieValue = getValue();
            if (dieValue != 1) {
                result = dieValue * 100;
            }
            return 8 * result;
        }
        return 0;
    }
}
