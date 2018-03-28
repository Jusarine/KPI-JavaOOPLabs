package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab4Main {

    private static MyLinkedList<Word> palindromes;
    private static Text text;

    public static void main(String[] args) {

        text = new Text(readFile());
        text.parseText();
        System.out.println(text);

        findPalindromes();
        findMaxPalindrome();

    }

    private static StringBuffer readFile(){
         StringBuffer sb = new StringBuffer();

        File file = new File("data/sentences.txt");

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (sc != null) {
            while (sc.hasNext()) {
                sb.append(sc.nextLine());
                sb.append("\n");
            }
        }
        return sb;
    }

    private static void findPalindromes(){
        palindromes = new MyLinkedList<>();
        for (Sentence sentence : text.getSentences()) {
            for (SentenceMember sentenceMember : sentence.getSentenceMembers()) {

                if (sentenceMember instanceof Word){
                    Word word = (Word) sentenceMember;
                    MyLinkedList<Letter> letters = word.getWord();

                    for (int i = 1; i < letters.size()-1; i++) {
                        for (int j = 1; (i + j) < letters.size(); j++) {
                            if (j < (i + 1) && letters.get(i - j).equalsInLowerCase(letters.get(i + j))) { // type ana
                                Word palindrome = new Word();
                                palindrome.addLetters(word.toString().substring(i - j, i + j + 1).toLowerCase());
                                palindromes.add(palindrome);
                            } else break;
                        }
                        for (int j = 1; (i + j) < letters.size(); j++) {
                            if (j < (i + 2) && letters.get(i - j + 1).equalsInLowerCase(letters.get(i + j))) { // type anna
                                Word palindrome = new Word();
                                palindrome.addLetters(word.toString().substring(i - j + 1, i + j + 1).toLowerCase());
                                palindromes.add(palindrome);
                            } else break;
                        }
                    }
                }
            }
        }
        System.out.println("Palindromes: " + palindromes);
    }

    private static void findMaxPalindrome(){
        Word max = palindromes.get(0);
        for (Word palindrome : palindromes) {
            if (palindrome.length() > max.length()){
                max = palindrome;
            }
        }
        System.out.println("Max palindrome: " + max);
    }
}
