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
                            .map(name -> new Car(name))
                            .collect(Collectors.toList());
    }

    public static boolean checkValidationCars(String carNames) {
        List<String> nameArray = Arrays.asList(carNames.split(SEPARATOR_OF_INPUT_CAR_NAME));
        return nameArray.stream()
                .filter(name -> Car.checkValidationCar(name) == false)
                .count() == 0;

    }

    public void moveCars(MoveStrategy moveStrategy) {
        this.cars.stream()
                .filter(car -> moveStrategy.movable() == true)
                .forEach(car -> car.move());
    }

    public List<String> whoAreWinner() {
        Integer maxPosition = whereIsWinner();
        return this.cars.stream()
                .filter(car -> car.isThere(maxPosition))
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    private Integer whereIsWinner() {
        return this.cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
    }

    @Override
    public String toString() {
        String carsPosition = new String();

        for( Car car : this.cars ) {
            carsPosition += car.toString() + "\n";
        }

        return carsPosition;
    }
}
