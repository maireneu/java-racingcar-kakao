package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String SEPARATOR_OF_INPUT_CAR_NAME = ",";
    List<Car> cars;

    public Cars(String carNames) {

        if( !checkValidationCars(carNames) ) {
            throw new IllegalArgumentException();
        }

        this.cars = Arrays.stream( carNames.split(SEPARATOR_OF_INPUT_CAR_NAME))
                            .map(name -> new Car(name))
                            .collect(Collectors.toList());
    }

    public static boolean checkValidationCars(String carNames) {
        List<String> nameArray = Arrays.asList(carNames.split(SEPARATOR_OF_INPUT_CAR_NAME));
        return nameArray.stream()
                .filter(name -> Car.checkValidationCar(name) == false)
                .count() == 0;

    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getCarsSize() {
        return this.cars.size();
    }

    public List<Integer> getCarsPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

}
