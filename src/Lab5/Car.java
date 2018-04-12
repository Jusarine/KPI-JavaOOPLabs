package Lab5;

public class Car extends Toy{

    /** number of wheels */
    private int wheelsCount;

    public Car(){

    }

    public Car(int maxAge, float prize, Size size, Color color) {
        super(maxAge, prize, size, color);
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
