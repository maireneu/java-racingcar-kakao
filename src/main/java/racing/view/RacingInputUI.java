package racing.view;

import racing.domain.Cars;
import racing.domain.NumberOfTrials;

import java.util.Scanner;

public class RacingInputUI {

    private static final String PRINT_CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String PRINT_CAR_NAME_VALIDATION_ERROR = "자동차 이름을 잘못 입력하셨습니다.";
    private static final String PRINT_TRIALS_QUESTION = "시도할 횟수는 몇회인가요?";
    private static final String PRINT_TRIALS_VALIDATION_ERROR = "횟수를 잘못 입력하셨습니다.";
    private static Scanner sc = new Scanner(System.in);


    public static String inputCarNames() {
        String names;
        do {
            System.out.println(PRINT_CAR_NAME_QUESTION);
            names = sc.nextLine();
        } while(!checkValidationCarNames(names));
        return names;
    }

    private static boolean checkValidationCarNames(String names) {
        if(!Cars.checkValidationCars(names) ) {
            System.out.println(PRINT_CAR_NAME_VALIDATION_ERROR);
            return false;
        }
        return true;
    }

    public static int inputNumberOfTrials() {
        int numberOfTrials;

        do {
            System.out.println(PRINT_TRIALS_QUESTION);
            numberOfTrials = inputValidNumber();
        } while( !checkValidationTrials(numberOfTrials) );

        return numberOfTrials;
    }

    private static int inputValidNumber() {
        int numberOfTrials;
        try {
            String input = sc.nextLine();
            numberOfTrials = Integer.parseInt(input);
        } catch (Exception e) {
            numberOfTrials = 0;
        }
        return numberOfTrials;
    }

    private static boolean checkValidationTrials( int numberOfTrials ) {
        if( !NumberOfTrials.checkValidationTrails(numberOfTrials) ) {
            System.out.println(PRINT_TRIALS_VALIDATION_ERROR);
            return false;
        }
        return true;
    }

}
