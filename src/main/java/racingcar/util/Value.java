package racingcar.util;

public enum Value {
    RANDOM_MIN(0),
    RANDOM_MAX(9),
    MOVE_MIN(3),
    LAST_TWO_CHAR(2),
    CAR_COUNT_MAX(5),
    CAR_NAME_LENGTH_MAX(5);

    private final int value;

    Value(int value) {
        this.value = value;
    }

    public int print() {
        return value;
    }
} // enum