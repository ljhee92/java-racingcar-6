package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private final OutputView outputView;
    private final InputView inputView;
    private final Validator validator;

    public RaceController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.validator = new Validator();
    } // RaceController

    public void runRacingCar() {
        outputView.printStartRace();
        String[] carNames = validator.getValidCarName(inputView.inputCarNames());

        outputView.printGetMoveCount();
        int moveCount = validator.getValidMoveCount(inputView.inputMoveCount());

        outputView.printResult();
        move(carNames, moveCount);
    } // runRacingCar

    public List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        } // end for

        return cars;
    } // createCars

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    } // createRandomNumber

    public void move(String[] carNames, int moveCount) {
        List<Car> cars = createCars(carNames);
        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                car.setPosition(createRandomNumber());
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            } // end for
            System.out.println();
        } // end for
    } // move
} // class