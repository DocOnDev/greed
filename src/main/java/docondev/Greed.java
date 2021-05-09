package docondev;

import java.util.ArrayList;
import java.util.List;

public class Greed {
    private List<Integer> dice = new ArrayList<>();

    public Integer score() {
        return dice.stream().map( die -> scoreOneDie(die)).reduce(0, Integer::sum);
    }

    private Integer scoreOneDie(Integer die) {
        if ( die == 1) return 100;
        return 50;
    }

    public void addDice(Integer die) {
        this.dice.add(die);
    }
}
