package Lab4;

public class Sentence {
    private MyLinkedList<SentenceMember> sentenceMembers;

    public Sentence(String sentence){
        sentenceMembers = new MyLinkedList<>();

        for (String strSentenceMember : sentence.split("\\s|(?<=[,.!?])|(?=[,.!?])")) {
            if (strSentenceMember.equals(".") || strSentenceMember.equals("!") || strSentenceMember.equals("?")){
                sentenceMembers.add(new Punctuation(strSentenceMember.charAt(0)));
            }
            else if (strSentenceMember.equals(",")){
                sentenceMembers.add(new Punctuation(strSentenceMember.charAt(0)));
            } else {
                sentenceMembers.add(new Word(strSentenceMember));
            }
        }
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
