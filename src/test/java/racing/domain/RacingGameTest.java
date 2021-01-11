package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    void racingGameTest(final String input) {
        RacingGame racingGame = new RacingGame(input);
        for (int i = 0; i < 5; i++) {
            racingGame.race(() -> true);
        }

        assertThat(racingGame.findWinnersName())
                .isEqualTo("pobi, crong, honux, ");
    }
}
