package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

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
    } // runRacingCar
} // class