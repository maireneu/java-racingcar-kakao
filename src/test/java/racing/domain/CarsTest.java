package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdef,fghijh,klmn"})
    void validateErrorTest(String names) {
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(Cars.checkValidationCars(names)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdf,fghij,klmn"})
    void validatePassTest(String names) {
        Cars cars = new Cars(names);
        assertThat(Cars.checkValidationCars(names)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdf,fghij,klmn"})
    void winnersTest(String names) {
        Cars cars = new Cars(names);
        for (int i = 0; i < 5; i++) {
            cars.moveCars(() -> true);
        }

        assertThat(cars.whereIsWinner()).isEqualTo(5);
        assertThat(cars.whoAreWinner()).asList()
                .contains("abcdf")
                .contains("fghij")
                .contains("klmn");
    }

}
