package racing.domain;

public class NumberOfTrials {

    private static final Integer MIN_TRIALS = 0;
    private Integer numberOfTrials = 0;

    public NumberOfTrials(int numberOfTrials) {
        if( !checkValidationTrails(numberOfTrials) ) {
            throw new IllegalArgumentException();
        }

        this.numberOfTrials = numberOfTrials;
    }

    public static boolean checkValidationTrails(int numberOfTrials) {
        if( numberOfTrials < MIN_TRIALS ) {
            return false;
        }
        return true;
    }

}
