package Lab5;

import Lab7.WrongMinAgeException;
import Lab7.WrongPrizeException;

public class Cube extends Toy{

    /** number of cube faces */
    private int edges = 4;

    public Cube(){

    }

    public Cube(int minAge, float prize, Size size, Color color) throws WrongMinAgeException, WrongPrizeException {
        super(minAge, prize, size, color);
    }

    public int getEdges() {
        return edges;
    }

    public void turn(){

    }
}
