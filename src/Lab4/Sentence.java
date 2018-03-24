package Lab4;

public class Sentence {
    private MyLinkedList<SentenceMember> sentenceMembers;


    public Sentence(){
        sentenceMembers = new MyLinkedList<>();
    }
    public void addWord(Word word){
        sentenceMembers.add(word);

    }

    public void addPunctuation(Punctuation punctuation){
        sentenceMembers.add(punctuation);
    }

    public MyLinkedList<SentenceMember> getSentenceMembers() {
        return sentenceMembers;
    }

    @Override
    public String toString() {
        String s = "";
        for (SentenceMember sentenceMember: sentenceMembers) {
            s += sentenceMember + " ";
        }
        s = s.replaceAll("\\s\\.",  ".").replaceAll("\\s,", ",").replaceAll("\\s!", "!").replaceAll("\\s\\?", "?");
        return s;
    }
}
