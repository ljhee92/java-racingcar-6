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
        outputView.displayMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = validator.getValidCarName(inputView.inputCarNames());

        outputView.displayMessage("시도할 회수는 몇회인가요?");
        int moveCount = validator.getValidMoveCount(inputView.inputMoveCount());

        outputView.displayMessage("");
        outputView.displayMessage("실행 결과");
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
                car.setPosition(checkMove(createRandomNumber()));
                outputView.displayMessage(car.getName() + " : " + "-".repeat(car.getPosition()));
            } // end for
            outputView.displayMessage("");
        } // end for
    } // move

    public boolean checkMove(int randomNumber) {
        return randomNumber > 3;
    } // checkMove
} // class