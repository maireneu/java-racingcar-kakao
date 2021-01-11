package racing.domain;

public class Car {

    private static final int MAX_NAME_SIZE = 5;
    private String name;
    private int position = 0;

    public Car(String name) {
        if( !checkValidationCar(name) ) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public Car(String name, int position) {
        if( !checkValidationCar(name) ) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = position;
    }

    public static boolean checkValidationCar(String name) {
        if( name.length() > Car.MAX_NAME_SIZE ) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position++;
    }

    @Override
    public String toString() {
        StringBuilder posBar = new StringBuilder();

        for(int i = 0; i < this.position; i++) {
            posBar.append("-");
        }

        return this.name + " : " + posBar;
    }
}
