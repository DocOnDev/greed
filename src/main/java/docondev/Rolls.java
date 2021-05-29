package docondev;

import java.security.InvalidParameterException;

public class Rolls {
    private final Integer[] value;
    private Integer baseDigit;

    public Rolls(Integer[] value) {
        this.value = value;
        baseDigit = this.value[0];
        confirmValidRolls();
    }

    int score() {
        if (value.length == 1) {
            if (baseDigit == 1) return 100;
            if (baseDigit == 5) return 50;
        }
        if (value.length == 3) {
            if (baseDigit ==1) return 1000;
            return baseDigit * 100;
        }
        if (value.length == 4) {
            int result = 1000;
            if (baseDigit != 1) {
                result = baseDigit * 100;
            }
            return result * 2;
        }
        if (value.length == 5) {
            int result = 1000;
            if (baseDigit != 1) {
                result = baseDigit * 100;
            }
            return result * 4;
        }
        return 0;
    }

    private void confirmValidRolls() {
        if (baseDigit <1 || baseDigit >6) throw new InvalidParameterException();
    }
}
