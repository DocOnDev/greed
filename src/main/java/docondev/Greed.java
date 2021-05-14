package docondev;

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
        if (set.size() == 3) return scoreTriples(set);
        if (set.size() == 4) return scoreQuads(set);
        if (set.size() == 5) return scoreQuints(set);
        if (set.size() == 6) return scoreSects(set);
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

    private Integer scoreTriples(DiceSet dice) {
        Integer dieValue = dice.getValue();
        if (dieValue == 1) return 1000;
        return dieValue * 100;
    }

    private Integer scoreQuads(DiceSet dice) {
        return 2 * scoreTriples(dice);
    }

    private Integer scoreQuints(DiceSet dice) {
        return 4 * scoreTriples(dice);
    }

    private Integer scoreSects(DiceSet dice) {
        return 8 * scoreTriples(dice);
    }

}
