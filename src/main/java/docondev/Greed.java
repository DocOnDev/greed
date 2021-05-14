package docondev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Greed {
    private List<Integer> dice = new ArrayList<>();

    public void addDice(Integer dieValue) {
        Die die = new Die(dieValue);
        if (dieValue < 1 || dieValue > 6 ) throw new IllegalArgumentException("Die value must be between 1 and 6");
        dice.add(dieValue);
    }

    public Integer score() {
        Integer result = 0;
        for ( List<Integer> set : createValueSets()) {
            result += scoreSet(set);
        }
        return result;
    }

    private Integer scoreSet(List<Integer> set) {
        if (set.size() == 1) return scoreSingles(set);
        if (set.size() == 2) return scoreDoubles(set);
        if (set.size() == 3) return scoreTriples(set);
        if (set.size() == 4) return scoreQuads(set);
        if (set.size() == 5) return scoreQuints(set);
        if (set.size() == 6) return scoreSects(set);
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

    private class Die {
        private final Integer value;

        public Die(Integer value) {
            this.value = value;
        }
    }
}
