package docondev;

import static java.util.stream.IntStream.rangeClosed;

class Die {
    public static final int LOW_VALUE = 1;
    public static final int HIGH_VALUE = 6;
    private final Integer value;

    public Die(Integer dieValue) {
        if (!isValidValue(dieValue)) throw new IllegalArgumentException("Die value must be between 1 and 6");
        this.value = dieValue;
    }

    private boolean isValidValue(Integer dieValue) {
        return rangeClosed(LOW_VALUE, HIGH_VALUE).anyMatch(num -> num == dieValue);
    }

    public Integer getValue() {
        return value;
    }
}
