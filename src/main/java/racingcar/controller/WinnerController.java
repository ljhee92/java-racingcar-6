package racingcar.controller;

import racingcar.model.Car;
import racingcar.util.Message;
import racingcar.util.Value;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnerController {
    private final OutputView outputView;

    public WinnerController() {
        this.outputView = new OutputView();
    } // WinnerController

    public List<Car> selectWinner(List<Car> movedCars) {
        Collections.sort(movedCars, (a, b) -> b.getPosition() - a.getPosition());

        List<Car> winners = new ArrayList<>();
        int winnerPosition = movedCars.get(0).getPosition();

        for (Car car : movedCars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car);
            } // end if
        } // end for

        return winners;
    } // selectWinner

    public void displayWinner(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder(Message.FINAL_WINNER.print());
        String selectedWinnerNames = selectSoleOrJoint(winners);

        winnerNames.append(selectedWinnerNames);
        outputView.displayMessage(winnerNames.toString());
    } // displayWinner

    public String selectSoleOrJoint(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();

        for (Car car : winners) {
            winnerNames.append(car.getName() + Message.JOIN.print());
        } // end for

        winnerNames.setLength(winnerNames.length() - Value.LAST_TWO_CHAR.print());
        return winnerNames.toString();
    } // displayJointWinner
} // class