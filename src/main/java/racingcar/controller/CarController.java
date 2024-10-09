package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.util.Message;
import racingcar.util.Value;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private final OutputView outputView;

    public CarController() {
        this.outputView = new OutputView();
    } // WinnerController

    public List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        } // end for

        return cars;
    } // createCars

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(Value.RANDOM_MIN.print(), Value.RANDOM_MAX.print());
    } // createRandomNumber

    public List<Car> move(String[] carNames, int moveCount) {
        List<Car> cars = createCars(carNames);

        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                car.setPosition(checkMove(createRandomNumber()));
                outputView.displayMessage(car.getName() + Message.COLON.print() + Message.MOVE_BAR.print().repeat(car.getPosition()));
            } // end for
            outputView.displayMessage(Message.LINE.print());
        } // end for

        return cars;
    } // move

    public boolean checkMove(int randomNumber) {
        return randomNumber > Value.MOVE_MIN.print();
    } // checkMove
} // class