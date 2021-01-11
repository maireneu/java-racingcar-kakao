package racing.domain;

import racing.RandomValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameLogic {

    private static final String SEPARATOR_OF_WINNERS = ", ";

    private Cars cars;
    private int maxProgressNumber;

    public RacingGameLogic(String carsName, int numberOfTrials) {
        this.cars = new Cars(carsName);
        this.maxProgressNumber = numberOfTrials;
    }

    public void race(MoveStrategy moveStrategy) {
        this.cars.moveCars(moveStrategy);
    }

    public String findWinnersName() {
        List<String> winners = this.cars.whoAreWinner();
        String winnerNames = new String();

        for(String name: winners) {
            winnerNames += name + SEPARATOR_OF_WINNERS;
        }

        return winnerNames.substring(0, winnerNames.length()-SEPARATOR_OF_WINNERS.length());
    }
}
