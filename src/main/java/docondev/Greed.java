package docondev;

public class Greed {
    public Integer score(Integer[] value) {
        if (value[0]==1) return 100;
        if (value[0]==5) return 50;
        return 0;
    }
}
