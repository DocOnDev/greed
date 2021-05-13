package docondev;

import java.util.ArrayList;
import java.util.List;

public class Greed {
    private List<Integer> dice = new ArrayList<>();

    public Integer score() {
        if (dice.size() == 3) return scoreTriples(dice);
        return dice.stream().map( die -> scoreOneDie(die)).reduce(0, Integer::sum);
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
