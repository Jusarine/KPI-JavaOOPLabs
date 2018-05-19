package Lab5;

import Lab7.WrongMinAgeException;
import Lab7.WrongPrizeException;

public class Ball extends Toy{

    public Ball(){

    }

    public Ball(int minAge, float prize, Size size, Color color) throws WrongMinAgeException, WrongPrizeException {
        super(minAge, prize, size, color);
    }

    public void wheel(){

    }

    public void jump(){

    }

    public void stop(){

    }
}
