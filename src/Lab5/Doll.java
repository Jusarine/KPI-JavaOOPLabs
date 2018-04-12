package Lab5;

public class Doll extends Toy{

    private String name;

    public Doll(){

    }

    public Doll(int maxAge, float prize, Size size, Color color) {
        super(maxAge, prize, size, color);
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
