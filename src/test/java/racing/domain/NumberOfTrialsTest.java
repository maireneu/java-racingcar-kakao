package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumberOfTrialsTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void validateErrorTest(int input) {
        assertThatThrownBy(() -> {
            new NumberOfTrials(input);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThat(NumberOfTrials.checkValidationTrails(input)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void validatePassTest(int input) {
        NumberOfTrials numberOfTrials = new NumberOfTrials(input);
        assertThat(NumberOfTrials.checkValidationTrails(input)).isTrue();
    }

}
