package racing.domain;

public class NumberOfTrials {

    private static final Integer MIN_TRIALS = 1;
    private Integer numberOfTrials;

    public NumberOfTrials(int numberOfTrials) {
        if( !checkValidationTrails(numberOfTrials) ) {
            throw new IllegalArgumentException();
        }

        this.numberOfTrials = numberOfTrials;
    }

    public static boolean checkValidationTrails(int numberOfTrials) {
        return numberOfTrials >= MIN_TRIALS;
    }

    public boolean tryRace(){
       if(this.numberOfTrials < MIN_TRIALS) {
           return false;
       }
       this.numberOfTrials -= 1;
       return true;
    }



}
