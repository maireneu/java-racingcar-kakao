package racing;

import racing.domain.NumberOfTrials;
import racing.domain.RacingGame;
import racing.domain.RandomMoveStrategy;
import racing.view.RacingInputUI;
import racing.view.RacingOutputUI;

public class RacingGameMain {

    private static RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

    public static void main(String[] args) {
        RacingGameMain racingGameMain = new RacingGameMain();
        racingGameMain.run();
    }

    public void run() {
        RacingGame racingGame = new RacingGame(RacingInputUI.inputCarNames());
        NumberOfTrials numberOfTrials = new NumberOfTrials(RacingInputUI.inputNumberOfTrials());
        RacingOutputUI.printPreRacingResult();

        while(numberOfTrials.tryRace()) {
            racingGame.race(randomMoveStrategy);
            RacingOutputUI.racePrint(racingGame.getRaceString());
        }

        RacingOutputUI.racePrint(racingGame.getRaceString());
        RacingOutputUI.printWinner(racingGame.findWinnersName());
    }

}