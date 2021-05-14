package docondev;

public class Greed {
    private Dice dice = new Dice();

    public void addDie(Integer dieValue) {
        dice.add(new Die(dieValue));
    }

    public Integer score() {
        Integer result = 0;
        for (DiceSet set : dice.groupByValue()) {
            result += set.scoreSet();
        }
        return result;
    }

}
