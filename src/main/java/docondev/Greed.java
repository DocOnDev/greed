package docondev;

public class Greed {
    private Integer die;

    public Integer score() {
        if ( die == 1) return 100;
        return 50;
    }

    public void addDice(Integer die) {
        this.die = die;
    }
}
