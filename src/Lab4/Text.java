package Lab4;

public class Text {
    private MyLinkedList<Sentence> sentences;

    public Text(String text){
        sentences = new MyLinkedList<>();

        for (String strSentence : text.split("(?<=[.!?])\\s*")) {
            Sentence sentence = new Sentence(strSentence);
            sentences.add(sentence);
        }
    }

    public MyLinkedList<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        String s = "";
        for (Sentence sentence : sentences) {
            s = s + "\n" + sentence;
        }
        return s;
    }
}