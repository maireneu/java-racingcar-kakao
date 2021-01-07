package racing.view;

import racing.domain.RacingGameLogic;

import java.util.Scanner;

public class RacingInputUI {

    private static final String PRINT_CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String PRINT_TRIALS_QUESTION = "시도할 횟수는 몇회인가요?";
    private static Scanner sc = new Scanner(System.in);


    public static String inputCarNames() {
        System.out.println(PRINT_CAR_NAME_QUESTION);
        return sc.next();
    }

    public static int inputNumberOfTrials() {
        System.out.println(PRINT_TRIALS_QUESTION);
        return sc.nextInt();
    }

}