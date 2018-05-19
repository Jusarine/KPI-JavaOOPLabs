package Lab7;

public class WrongMinAgeException extends Exception {
    public WrongMinAgeException(int minAge) {
        super("MinAge=" + minAge);
    }
}
