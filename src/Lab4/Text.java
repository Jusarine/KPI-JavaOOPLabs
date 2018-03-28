package Lab4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private MyLinkedList<Sentence> sentences;
    private StringBuffer text;

    public Text(StringBuffer text){
        this.text = text;
        sentences = new MyLinkedList<>();
    }


    public void parseText(){

        String pattern = "[^.!?]+[.!?]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text.toString());

        while(m.find()) {
            String strSentence = text.toString().substring(m.start(), m.end()).trim();
            String[] strWords = strSentence.split("\\s");

            Sentence sentence = new Sentence();

            for (String strWord : strWords) {

                //strWord = strWord.toLowerCase();
                Word word = new Word();

                Punctuation punctuation = null;
                for (char strCharacter : strWord.toCharArray()) {
                    if(strCharacter == '.' || strCharacter == '!' || strCharacter == '?' || strCharacter == ',') {
                        punctuation = new Punctuation(strCharacter);
                    }
                    else {
                        word.addLetter(strCharacter);
                    }
                }
                sentence.addWord(word);

                if(punctuation != null){
                    sentence.addPunctuation(punctuation);
                }
            }
            sentences.add(sentence);
        }
        //System.out.println(text);
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