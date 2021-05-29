package docondev;

public class Greed {
    public Integer score(Integer[] diceValues) {
        Rolls rolls = new Rolls(new DiceSet(diceValues));
        return rolls.score();
    }
}
