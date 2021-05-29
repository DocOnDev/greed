package docondev;

public class Greed {
    public Integer score(Integer[] diceValues) {
        Rolls rolls = new Rolls(diceValues);
        if (rolls.isaTriple()) return rolls.scoreTriple();
        return scoreSingle(rolls);
    }

    private int scoreSingle(Rolls rolls) {
        if (rolls.getFirstDigit() ==1) return 100;
        if (rolls.getFirstDigit() ==5) return 50;
        return 0;
    }

}
