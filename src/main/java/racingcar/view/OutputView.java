package racingcar.view;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public void printStartRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    } // printStartRace

    public void printGetMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    } // printGetMoveCount

    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }
} // class