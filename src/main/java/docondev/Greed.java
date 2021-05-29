package docondev;

public class Greed {
    public Integer score(Integer[] diceValues) {
        Rolls rolls = new Rolls(diceValues);
        if (rolls.isaTriple()) return rolls.scoreTriple();
        return rolls.scoreSingle();
    }

}
