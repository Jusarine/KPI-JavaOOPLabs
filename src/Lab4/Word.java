package Lab4;

public class Word implements SentenceMember {
    private MyLinkedList<Letter> word;

    public Word(String letters) {
        word = new MyLinkedList<>();
        for (char c : letters.toCharArray()) {
            word.add(new Letter(c));
        }
    }

    public MyLinkedList<Letter> getLetters() {
        return word;
    }

    public int length() {
        return word.size();
    }

    @Override
    public String toString() {
        String s = "";
        for (Letter letter : word) {
            s += letter;
        }
        return s;
    }
}
