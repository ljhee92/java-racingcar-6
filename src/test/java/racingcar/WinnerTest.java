package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.controller.WinnerController;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("우승자 선정 테스트")
public class WinnerTest {
    private WinnerController winnerController;

    @BeforeEach
    void init() {
        winnerController = new WinnerController();
    } // init

    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("단독/공동 우승자 출력 형식")
    @MethodSource("generateData")
    void testWinner(List<Car> cars, String output, String message) {
        assertThat(winnerController.selectSoleOrJoint(cars)).isEqualTo(output);
    } // testWinner

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Car("pobi")), "pobi", "단독 우승자"),
                Arguments.of(Arrays.asList(new Car("pobi"), new Car("woni")), "pobi, woni", "공동 우승자")
        );
    } // generateData
} // class