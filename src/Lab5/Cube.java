package Lab5;

public class Cube extends Toy{

    /** number of cube faces */
    private int edges = 4;

    public Cube(){

    }

    public Cube(int maxAge, float prize, Size size, Color color) {
        super(maxAge, prize, size, color);
    }

    public int getEdges() {
        return edges;
    }

    public void turn(){

    }
}
