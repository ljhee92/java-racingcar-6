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
        String[] carNames = checkValidCarName(inputView.inputCarNames());

        outputView.printGetMoveCount();
        int moveCount = getValidMoveCount(inputView.inputMoveCount());
    } // runRacingCar

    public String[] checkValidCarName(String inputCarNames) {
        validator.doesSplitComma(inputCarNames);
        validator.countCarName(inputCarNames);
        validator.validCarNameLength(inputCarNames);

        return inputCarNames.split(",");
    } // checkValidCarName

    public int getValidMoveCount(String inputMoveCount) {
        return validator.validMoveCount(inputMoveCount);
    } // getValidMoveCount
} // class