package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcde"})
    void ValidateErrorTest(String name) {
        if( name.length() > Car.MAX_NAME_SIZE ) {
            assertThatThrownBy(() -> {
                new Car(name);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcde"})
    void ValidatePassTest(String name) {
        Car car = new Car(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    void moveTest(String input) {
        Car car = new Car(input, 3);

        assertThat(car.getPosition()).isEqualTo(3);
        for (int i = 0; i < 5; i++) {
            car.move();
        }
        assertThat(car.getPosition()).isEqualTo(8);
    }

}
