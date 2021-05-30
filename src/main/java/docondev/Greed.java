package docondev;

public class Greed {
    public Integer score(Integer[] diceValues) {
        DiceSet diceSet = new DiceSet(diceValues) {
            @Override
            int score() {
                return 0;
            }
        };
        return diceSet.getSet().score();
    }
}
