package docondev;

public class Greed {
    public Integer score(Integer[] diceValues) {
        Rolls rolls = new Rolls(diceValues);
        return rolls.score();
    }
}
