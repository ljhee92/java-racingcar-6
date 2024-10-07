package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RaceController;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 객체 테스트")
public class CarTest {
    private RaceController raceController;

    @BeforeEach
    void init() {
        raceController = new RaceController();
    } // init

    @Test
    @DisplayName("자동차 객체가 생성되는지")
    void testCreateCar() {
        assertThat(new Car("pobi")).isNotNull();
    } // testCreateCar

    @Test
    @DisplayName("입력한 이름의 개수만큼 객체가 생성되는지")
    void testCreateCarByInput() {
        assertThat(raceController.createCars("pobi,woni,jun".split(",")).size()).isEqualTo(3);
    } // testCreateCarByInput

    @Test
    @DisplayName("랜덤값이 생성되는지")
    void testRandomNumber() {
        assertThat(raceController.createRandomNumber()).isBetween(0, 9);
    } // testRandomNumber
} // class