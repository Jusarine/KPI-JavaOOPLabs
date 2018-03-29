package Lab4;

public class Text {
    private MyLinkedList<Sentence> sentences;
    private StringBuffer text;

    public Text(StringBuffer text){
        this.text = text;
        sentences = new MyLinkedList<>();
    }

    public void parseText() {

        Sentence sentence = new Sentence();
        for (String strSentenceMember : text.toString().split("\\s|(?=[,.!?])|(?<=[,.!?])")) {

            if (strSentenceMember.equals(".") || strSentenceMember.equals("!") || strSentenceMember.equals("?")) {
                sentence.addPunctuation(strSentenceMember.charAt(0));
                sentences.add(sentence);
                sentence = new Sentence();

            } else if (strSentenceMember.equals(",")){
                sentence.addPunctuation(strSentenceMember.charAt(0));

            } else {
                sentence.addWord(strSentenceMember);
            }
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