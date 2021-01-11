package racing.domain;

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
                            .map(Car::new)
                            .collect(Collectors.toList());
    }

    public static boolean checkValidationCars(String carNames) {
        List<String> nameArray = Arrays.asList(carNames.split(SEPARATOR_OF_INPUT_CAR_NAME));
        return nameArray.stream()
                .noneMatch(name -> !Car.checkValidationCar(name));
    }

    public void moveCars(MoveStrategy moveStrategy) {
        this.cars.stream()
                .filter(car -> moveStrategy.movable())
                .forEach(Car::move);
    }

    public List<String> whoAreWinner() {
        Integer maxPosition = whereIsWinner();
        return this.cars.stream()
                .filter(car -> car.isThere(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Integer whereIsWinner() {
        return this.cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
    }

    @Override
    public String toString() {
        String carsPosition = "";

        for( Car car : this.cars ) {
            carsPosition += car.toString() + "\n";
        }

        return carsPosition;
    }
}
