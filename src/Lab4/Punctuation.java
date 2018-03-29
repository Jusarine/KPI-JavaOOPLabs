package Lab4;

public class Punctuation implements SentenceMember {
    private char punctuation;

    public Punctuation(char punctuation){
        this.punctuation = punctuation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punctuation that = (Punctuation) o;
        return punctuation == that.punctuation;
    }

    @Override
    public String toString() {
        return String.valueOf(punctuation);
    }
}
