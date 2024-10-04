package racingcar.controller;

public class Validator {
    private static final boolean VALID = true;

    public boolean doesSplitComma(String inputCarNames) {
        if (!inputCarNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분되어야 합니다.");
        } // end if
        return VALID;
    } // doesSplitComma

    public boolean countCarName(String inputCarNames) {
        if (inputCarNames.split(",").length > 5) {
            throw new IllegalArgumentException("자동차 이름은 총 5대까지만 입력 가능합니다.");
        } // end if
        return VALID;
    } // countCarName

    public boolean validCarNameLength(String inputCarNames) {
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 입력 가능합니다.");
            } // end if
        } // end for
        return VALID;
    } // validCarNameLength

    public int validMoveCount(String inputMoveCount) {
        if (!inputMoveCount.matches("^[1-5]*$")) {
            throw new IllegalArgumentException("이동 회수는 1과 5 사이의 숫자만 입력 가능합니다.");
        } // end if
        return Integer.parseInt(inputMoveCount);
    } // validMoveCount
} // class