package racingcar.util;

public enum Message {
    GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT("시도할 회수는 몇회인가요?"),
    LINE(""),
    GAME_RESULT("실행 결과"),
    COLON(" : "),
    MOVE_BAR("-"),
    FINAL_WINNER("최종 우승자 : "),
    JOIN(", "),
    SPLIT(","),
    CAR_NAME_SPLIT_ERROR("자동차 이름은 쉼표(,)로 구분되어야 합니다."),
    CAR_COUNT_ERROR("자동차 이름은 총 5대까지만 입력 가능합니다."),
    CAR_NAME_LENGTH_ERROR("자동차 이름은 5자 이하만 입력 가능합니다."),
    ONE_TO_FIVE_NUMBER("^[1-5]*$"),
    CAR_MOVE_COUNT_ERROR("이동 회수는 1과 5 사이의 숫자만 입력 가능합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
} // enum