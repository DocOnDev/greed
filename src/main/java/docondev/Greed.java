package docondev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Greed {
    private List<Integer> dice = new ArrayList<>();

    public void addDice(Integer die) {
        if (die < 1 || die > 6 ) throw new IllegalArgumentException("Die value must be between 1 and 6");
        dice.add(die);
    }

    public Integer score() {
        Integer result = 0;
        for ( List<Integer> set : createValueSets()) {
            result += scoreSet(new DieSet(set));
        }
        return result;
    }

    private Integer scoreSet(DieSet set) {
        List<Integer> dice = set.set;
        if (dice.size() == 1) return scoreSingles(dice);
        if (dice.size() == 2) return scoreDoubles(dice);
        if (dice.size() == 3) return scoreTriples(dice);
        if (dice.size() == 4) return scoreQuads(dice);
        if (dice.size() == 5) return scoreQuints(dice);
        if (dice.size() == 6) return scoreSects(dice);
        return 0;
    }

    private Integer scoreSingles(List<Integer> dice) {
        Integer die = dice.get(0);
        if ( die == 1) return 100;
        if ( die == 5) return 50;
        return 0;
    }

    private Integer scoreDoubles(List<Integer> dice) {
        return 2 * scoreSingles(dice);
    }

    private Integer scoreTriples(List<Integer> dice) {
        Integer dieValue = dice.get(0);
        if (dieValue == 1) return 1000;
        return dieValue * 100;
    }

    private Integer scoreQuads(List<Integer> dice) {
        return 2 * scoreTriples(dice);
    }

    private Integer scoreQuints(List<Integer> dice) {
        return 4 * scoreTriples(dice);
    }

    private Integer scoreSects(List<Integer> dice) {
        return 8 * scoreTriples(dice);
    }

    private List<List<Integer>> createValueSets() {
        return dice.stream()
                .collect(Collectors.groupingBy(die -> die))
                .values().stream()
                .collect(Collectors.toList());
    }

    private class DieSet {
        List<Integer> set = new ArrayList<>();

        public DieSet(List<Integer> set) {
            this.set = set;
        }
    }
}
