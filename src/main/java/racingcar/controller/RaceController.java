package racingcar.controller;

import racingcar.model.Car;
import racingcar.util.Message;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {
    private final OutputView outputView;
    private final InputView inputView;
    private final Validator validator;
    private final WinnerController winnerController;
    private final CarController carController;

    public RaceController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.validator = new Validator();
        this.winnerController = new WinnerController();
        this.carController = new CarController();
    } // RaceController

    public void runRacingCar() {
        outputView.displayMessage(Message.GAME_RESULT.print());
        String[] carNames = validator.getValidCarName(inputView.inputCarNames());

        outputView.displayMessage(Message.TRY_COUNT.print());
        int moveCount = validator.getValidMoveCount(inputView.inputMoveCount());

        List<Car> movedCars = carController.move(carNames, moveCount);

        List<Car> winners = winnerController.selectWinner(movedCars);
        winnerController.displayWinner(winners);
    } // runRacingCar
} // class