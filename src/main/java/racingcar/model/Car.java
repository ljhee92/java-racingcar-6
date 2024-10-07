package racingcar.model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int randomNumber) {
        if (randomNumber > 3) {
            this.position++;
        }
    }
} // class