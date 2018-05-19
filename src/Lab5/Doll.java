package Lab5;

import Lab7.WrongMinAgeException;
import Lab7.WrongPrizeException;

public class Doll extends Toy{

    private String name;

    public Doll(){

    }

    public Doll(int minAge, float prize, Size size, Color color) throws WrongMinAgeException, WrongPrizeException {
        super(minAge, prize, size, color);
    }

    public void speak(){

    }

    public void sitDown(){

    }

    public void standUp(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
