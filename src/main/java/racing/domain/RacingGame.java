package racing.domain;

import java.util.List;

public class RacingGame {

    public static final String SEPARATOR_OF_WINNERS = ", ";

    private Cars cars;

    public RacingGame(String carsName) {
        this.cars = new Cars(carsName);
    }

    public void race(MoveStrategy moveStrategy) {
        this.cars.moveCars(moveStrategy);
    }

    public String findWinnersName() {
        List<String> winners = this.cars.whoAreWinner();
        String winnerNames = "";

        for(String name: winners) {
            winnerNames += name + SEPARATOR_OF_WINNERS;
        }

        return winnerNames;
    }

    public String getRaceString() {
        return this.cars.toString();
    }
}
