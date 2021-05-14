package docondev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Dice {
    private List<Die> dieList = new ArrayList<>();

    public void add(Die die) {
        this.dieList.add(die);
    }

    public List<DiceSet> groupByValue() {
        return dieList.stream().collect(Collectors.groupingBy(die -> die.getValue()))
                .values().stream()
                .map(list -> new DiceSet(list))
                .collect(Collectors.toList());
    }

}
