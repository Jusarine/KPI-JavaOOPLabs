package Lab4WithMyLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Lab4 {
    // c3 = 1, c17 = 13
    // StringBuffer
    // В заданому тексті знайти підрядок максимальної довжини,
    // що є паліндромом, тобто читається однаково зліва на право та з права на ліво.

    private static StringBuffer res;
    private static StringBuffer text;



    public static void main(String[] args){

        readFile();
        findPalindromes(text.toString().split("\\W+"));
        findMaxPalindrome(res.toString().split("\r"));

    }

    private static void readFile(){
        text = new StringBuffer();

        File file = new File("data/palindromes.txt");

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (sc != null) {
            while (sc.hasNext()) {
                text.append(sc.nextLine());
                text.append("\r");
            }
        }
    }

    private static void findPalindromes(String[] arr){
        res = new StringBuffer();

        System.out.println("Substrings: " + Arrays.toString(arr));

        for (String elem : arr) {
            elem = elem.toLowerCase();

            for (int i = 1; i < elem.length()-1; i++) {
                for (int j = 1; (i + j) < elem.length(); j++) {
                    if (j < (i + 1) && elem.charAt(i - j) == elem.charAt(i + j)) { // type ana
                        res.append(elem.substring(i - j, i + j + 1));
                        res.append("\r");
                    }
                    else break;
                }
                for (int j = 1; (i + j) < elem.length(); j++) {
                    if (j < (i + 2) && elem.charAt(i - j + 1) == elem.charAt(i + j)) { // type anna
                        res.append(elem.substring(i - j + 1, i + j + 1));
                        res.append("\r");
                    }
                    else break;
                }
            }
        }
    }

    private static void findMaxPalindrome(String[] arr){
        System.out.println("Palindromes: " + Arrays.toString(arr));

        String max = arr[0];
        for (String elem : arr) {
            if (elem.length() > max.length()) {
                max = elem;
            }
        }

        System.out.println("Max palindrome: " + max);

    }
}
