package Lab4;

public class Word implements SentenceMember {
    private MyLinkedList<Letter> word;

    public Word(){
        word = new MyLinkedList<>();
    }

     public void addLetter(char character){
        Letter letter = new Letter(character);
        word.add(letter);
     }

     public void addLetters(String s){
        for(char c: s.toCharArray()){
            word.add(new Letter(c));
        }
     }

    public MyLinkedList<Letter> getWord() {
        return word;
    }

    public int length(){
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
