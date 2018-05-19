package Lab5;

import Lab7.WrongMinAgeException;
import Lab7.WrongPrizeException;

public class Car extends Toy{

    /** number of wheels */
    private int wheelsCount;

    public Car(){

    }

    public Car(int minAge, float prize, Size size, Color color) throws WrongMinAgeException, WrongPrizeException {
        super(minAge, prize, size, color);
    }

    public void ride(){

    }

    public void turn(){

    }

    public void stop(){

    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }
}
