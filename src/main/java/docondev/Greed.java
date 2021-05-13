package docondev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Greed {
    private List<Integer> dice = new ArrayList<>();

    public Integer score() {
        Integer result = 0;
        List<List<Integer>> sets = createValueSets();
        for ( List<Integer> set : sets ) {
            result += scoreSet(set);
        }
        return result;
    }

    private List<List<Integer>> createValueSets() {
        return dice.stream()
                .collect(Collectors.groupingBy(die -> die))
                .values().stream()
                .collect(Collectors.toList());
    }

    private Integer scoreSet(List<Integer> set) {
        if (set.size() == 3) return scoreTriples(set);
        if (set.size() == 4) return scoreQuads(set);
        if (set.size() == 5) return scoreQuints(set);
        if (set.size() == 6) return scoreSects(set);
        return set.stream().map( die -> scoreOneDie(die)).reduce(0, Integer::sum);
    }

    private Integer scoreSects(List<Integer> dice) {
        return 8 * scoreTriples(dice);
    }

    private Integer scoreQuints(List<Integer> dice) {
        return 4 * scoreTriples(dice);
    }

    private Integer scoreQuads(List<Integer> dice) {
        return 2 * scoreTriples(dice);
    }

    private Integer scoreTriples(List<Integer> dice) {
        Integer dieValue = dice.get(0);
        if (dieValue == 1) return 1000;
        return dieValue * 100;
    }

    private Integer scoreOneDie(Integer die) {
        if ( die == 1) return 100;
        if ( die == 5) return 50;
        return 0;
    }

    public void addDice(Integer die) {
        if (die < 1 || die > 6 ) throw new IllegalArgumentException("Die value must be between 1 and 6");
        this.dice.add(die);
    }
}
