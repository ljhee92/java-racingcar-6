package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarController;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 객체 테스트")
public class CarTest {
    private CarController carController;

    @BeforeEach
    void init() {
        carController = new CarController();
    } // init

    @Test
    @DisplayName("자동차 객체가 생성되는지")
    void testCreateCar() {
        assertThat(new Car("pobi")).isNotNull();
    } // testCreateCar

    @Test
    @DisplayName("입력한 이름의 개수만큼 객체가 생성되는지")
    void testCreateCarByInput() {
        assertThat(carController.createCars("pobi,woni,jun".split(",")).size()).isEqualTo(3);
    } // testCreateCarByInput

    @Test
    @DisplayName("0~9 사이 랜덤값이 생성되는지")
    void testRandomNumber() {
        assertThat(carController.createRandomNumber()).isBetween(0, 9);
    } // testRandomNumber

    @Test
    @DisplayName("랜덤값이 4이상일 때 전진하는지")
    void testMove() {
        assertThat(carController.checkMove(4)).isTrue();
    } // testMove

    @Test
    @DisplayName("랜덤값이 4미만일 때 전진하지 않는지")
    void testNotMove() {
        assertThat(carController.checkMove(3)).isFalse();
    } // testMove
} // class