package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.controller.RaceController;
import racingcar.controller.Validator;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사용자 입력 테스트")
public class InputTest {
    private Validator validator;
    private static final String INPUT_CAR_NAME = "pobi,woni,jun";
    private static final String INPUT_MOVE_COUNT = "3";

    @BeforeEach
    void init() {
        validator = new Validator();
    } // init

    @Test
    @DisplayName("자동차 이름이 쉼표로 구분되는지")
    void testCarNameSplit() {
        assertThat(validator.doesSplitComma(INPUT_CAR_NAME)).isTrue();
    } // testCarNameSplit

    @Test
    @DisplayName("입력한 자동차 이름의 개수가 5개 이하인지")
    void testCarNameCount() {
        assertThat(validator.countCarName(INPUT_CAR_NAME)).isTrue();
    } // testCarNameCount

    @Test
    @DisplayName("각 자동차 이름의 길이가 5자 이하인지")
    void testCarNameLength() {
        assertThat(validator.validCarNameLength(INPUT_CAR_NAME)).isTrue();
    } // testCarNameLength

    @Test
    @DisplayName("입력한 이동 회수가 1과 5 사이의 숫자인지")
    void testMoveCount() {
        assertThat(validator.validMoveCount(INPUT_MOVE_COUNT)).isBetween(1, 5);
    } // testMoveCount

    @ParameterizedTest(name = "{index} : {1}")
    @DisplayName("자동차 이름 입력 예외 테스트")
    @MethodSource("generateNameData")
    void testCarNameException(String input, String message) {
        assertThatThrownBy(() -> validator.getValidCarName(input))
                .isInstanceOf(IllegalArgumentException.class);
    } // testCarNameException

    static Stream<Arguments> generateNameData() {
        return Stream.of(
                Arguments.of("pobi/woni/jun", "쉼표구분아님"),
                Arguments.of("pobi,woni,jun,java,sql,c", "6개 이상"),
                Arguments.of("pobi,javaji", "6자 이상")
        );
    } // generateNameData

    @ParameterizedTest(name = "{index} : {1}")
    @DisplayName("이동 회수 입력 예외 테스트")
    @MethodSource("generateMoveCountData")
    void testMoveCountException(String input, String message) {
        assertThatThrownBy(() -> validator.getValidMoveCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    } // testMoveCountException

    static Stream<Arguments> generateMoveCountData() {
        return Stream.of(
                Arguments.of("0", "0"),
                Arguments.of("6", "6")
        );
    } // generateMoveCountData
} // class