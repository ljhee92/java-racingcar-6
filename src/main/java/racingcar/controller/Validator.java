package racingcar.controller;

import racingcar.util.Message;
import racingcar.util.Value;

public class Validator {
    private static final boolean VALID = true;

    public String[] getValidCarName(String inputCarNames) {
        doesSplitComma(inputCarNames);
        countCarName(inputCarNames);
        validCarNameLength(inputCarNames);

        return inputCarNames.split(Message.SPLIT.print());
    } // checkValidCarName

    public int getValidMoveCount(String inputMoveCount) {
        return validMoveCount(inputMoveCount);
    } // getValidMoveCount

    public boolean doesSplitComma(String inputCarNames) {
        if (!inputCarNames.contains(Message.SPLIT.print())) {
            throw new IllegalArgumentException(Message.CAR_NAME_SPLIT_ERROR.print());
        } // end if
        return VALID;
    } // doesSplitComma

    public boolean countCarName(String inputCarNames) {
        if (inputCarNames.split(Message.SPLIT.print()).length > Value.CAR_COUNT_MAX.print()) {
            throw new IllegalArgumentException(Message.CAR_COUNT_ERROR.print());
        } // end if
        return VALID;
    } // countCarName

    public boolean validCarNameLength(String inputCarNames) {
        String[] carNames = inputCarNames.split(Message.SPLIT.print());
        for (String carName : carNames) {
            if (carName.length() > Value.CAR_NAME_LENGTH_MAX.print()) {
                throw new IllegalArgumentException(Message.CAR_NAME_LENGTH_ERROR.print());
            } // end if
        } // end for
        return VALID;
    } // validCarNameLength

    public int validMoveCount(String inputMoveCount) {
        if (!inputMoveCount.matches(Message.ONE_TO_FIVE_NUMBER.print())) {
            throw new IllegalArgumentException(Message.CAR_MOVE_COUNT_ERROR.print());
        } // end if
        return Integer.parseInt(inputMoveCount);
    } // validMoveCount
} // class