package Lab7;

public class WrongPrizeException extends Exception {
    public WrongPrizeException(float prize){
        super("Prize=" + prize);
    }
}
