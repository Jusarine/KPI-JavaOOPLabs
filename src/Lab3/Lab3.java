package Lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Lab3 {
    // c3 = 1, c17 = 13
    // StringBuffer
    // В заданому тексті знайти підрядок максимальної довжини,
    // що є паліндромом, тобто читається однаково зліва на право та з права на ліво.

    public static void main(String[] args) throws FileNotFoundException {

        StringBuffer res = new StringBuffer();
        StringBuffer text = new StringBuffer();

        File file = new File("data/palindromes.txt");

        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            text.append(sc.nextLine());
            text.append("\n");
        }

        String[] arr = text.toString().split("\\W+");
        System.out.println("Substrings: " + Arrays.toString(arr));

        for (String elem : arr) {
            elem = elem.toLowerCase();

            for (int i = 1; i < elem.length()-1; i++) {
                for (int j = 1; (i + j) < elem.length(); j++) {
                    if (j < (i + 1) && elem.charAt(i - j) == elem.charAt(i + j)) { // type ana
                        res.append(elem.substring(i - j, i + j + 1));
                        res.append("\n");
                    }
                    else if (j < (i + 2) && elem.charAt(i - j + 1) == elem.charAt(i + j)) { // type anna
                        res.append(elem.substring(i - j + 1, i + j + 1));
                        res.append("\n");
                    }
                    else{
                        break;
                    }
                }
            }
        }

        String[] list = res.toString().split("\n");
        System.out.println("Palindromes: " + Arrays.toString(list));

        String max = list[0];
        for (String aList : list) {
            if (aList.length() > max.length()) {
                max = aList;
            }
        }

        System.out.println("Max palindrome: " + max);

    }
}
