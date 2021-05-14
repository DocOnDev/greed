package docondev;

import java.util.List;

public class Greed {
    private Dice dice = new Dice();

    public void addDie(Integer dieValue) {
        dice.add(new Die(dieValue));
    }

    public Integer score() {
        Integer result = 0;
        for (DiceSet set : dice.groupByValue()) {
            result += scoreSet(set);
        }
        return result;
    }

    private Integer scoreSet(DiceSet set) {
        if (set.size() == 1) return scoreSingles(set);
        if (set.size() == 2) return scoreDoubles(set);
        if (set.size() == 3) return scoreTriples(set.getList());
        if (set.size() == 4) return scoreQuads(set.getList());
        if (set.size() == 5) return scoreQuints(set.getList());
        if (set.size() == 6) return scoreSects(set.getList());
        return 0;
    }

    private Integer scoreSingles(DiceSet dice) {
        Integer die = dice.getValue();
        if ( die == 1) return 100;
        if ( die == 5) return 50;
        return 0;
    }

    private Integer scoreDoubles(DiceSet dice) {
        return 2 * scoreSingles(dice);
    }

    private Integer scoreTriples(List<Die> dice) {
        Integer dieValue = dice.get(0).getValue();
        if (dieValue == 1) return 1000;
        return dieValue * 100;
    }

    private Integer scoreQuads(List<Die> dice) {
        return 2 * scoreTriples(dice);
    }

    private Integer scoreQuints(List<Die> dice) {
        return 4 * scoreTriples(dice);
    }

    private Integer scoreSects(List<Die> dice) {
        return 8 * scoreTriples(dice);
    }

}
