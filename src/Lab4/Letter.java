package Lab4;

public class Letter {
    private char letter;

    public Letter(char letter){
        this.letter = letter;
    }

    public boolean equalsIgnoreCase(Letter letter) {
        return String.valueOf(this.letter).toLowerCase().equals(String.valueOf(letter).toLowerCase());
    }

    @Override
    public String toString() {
        return String.valueOf(letter);
    }
}
