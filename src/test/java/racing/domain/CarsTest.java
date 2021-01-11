package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdef,fghijh,klmn"})
    void validateErrorTest(String names) {
        assertThatThrownBy(() -> {
            new Cars(names);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThat(Cars.checkValidationCars(names)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdf,fghij,klmn"})
    void validatePassTest(String names) {
        Cars cars = new Cars(names);
        assertThat(Cars.checkValidationCars(names)).isTrue();
    }

}
