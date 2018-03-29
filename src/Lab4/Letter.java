package Lab4;

public class Letter {
    private char letter;

    public Letter(char letter){
        this.letter = letter;
    }

    public boolean equalsIgnoreCase(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter that = (Letter) o;
        return String.valueOf(letter).toLowerCase().equals(String.valueOf(that.letter).toLowerCase());
    }

    @Override
    public String toString() {
        return String.valueOf(letter);
    }
}
