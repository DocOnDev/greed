package docondev;

public class Greed {
    public Integer score(Integer[] value) {
        if (isaTriple(value)) return scoreTriple(value);
        if (value[0]==1) return 100;
        if (value[0]==5) return 50;
        return 0;
    }

    private boolean isaTriple(Integer[] value) {
        return value.length == 3;
    }

    private int scoreTriple(Integer[] value) {
        if (value[0]==2) return 200;
        return 1000;
    }
}
