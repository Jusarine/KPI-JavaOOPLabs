package Lab4WithMyLinkedList;

public class Letter {
    private char letter;

    public Letter(char letter){
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return String.valueOf(letter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter that = (Letter) o;
        return letter == that.letter;
    }
}
