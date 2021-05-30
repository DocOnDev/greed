package docondev;

public class Greed {
    public Integer score(Integer[] diceValues) {
        return SetFactory.getSet(diceValues).score();
    }
}