package docondev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.rangeClosed;

public class Greed {
    private List<Die> dice = new ArrayList<>();

    public void addDice(Integer dieValue) {
        dice.add(new Die(dieValue));
    }

    public Integer score() {
        Integer result = 0;
        for ( List<Die> set : groupDiceByValue()) {
            result += scoreSet(set);
        }
        return result;
    }

    private Integer scoreSet(List<Die> set) {
        if (set.size() == 1) return scoreSingles(set);
        if (set.size() == 2) return scoreDoubles(set);
        if (set.size() == 3) return scoreTriples(set);
        if (set.size() == 4) return scoreQuads(set);
        if (set.size() == 5) return scoreQuints(set);
        if (set.size() == 6) return scoreSects(set);
        return 0;
    }

    private Integer scoreSingles(List<Die> dice) {
        Integer die = dice.get(0).value;
        if ( die == 1) return 100;
        if ( die == 5) return 50;
        return 0;
    }

    private Integer scoreDoubles(List<Die> dice) {
        return 2 * scoreSingles(dice);
    }

    private Integer scoreTriples(List<Die> dice) {
        Integer dieValue = dice.get(0).value;
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

    private List<List<Die>> groupDiceByValue() {
        return dice.stream().collect(Collectors.groupingBy(die -> die.value))
                .values().stream()
                .collect(Collectors.toList());
    }

    private class Die {
        public static final int LOW_VALUE = 1;
        public static final int HIGH_VALUE = 6;
        private final Integer value;

        public Die(Integer dieValue) {
            if (!isValidValue(dieValue)) throw new IllegalArgumentException("Die value must be between 1 and 6");
            this.value = dieValue;
        }

        private boolean isValidValue(Integer dieValue) {
            return rangeClosed(LOW_VALUE, HIGH_VALUE).anyMatch(num -> num == dieValue);
        }
    }
}
