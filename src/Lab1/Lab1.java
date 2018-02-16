package Lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {

        //int c2 = 0, c3 = 1, c5 = 4, c7 = 4;
        //char o1 = '+', o2 = '-';

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter character n:");
        String n = sc.next();
        System.out.println("Enter character m:");
        String m = sc.next();
        sc.close();

        if (m.length() !=1 || n.length() != 1) throw new InputMismatchException();

        final int c = 1;
        float s = 0;

        for (char i = 0; i < n.charAt(0); i++) {
            if ((i + c) == 0) throw new ArithmeticException();
            for (char j = 0; j < m.charAt(0); j++) {
                s += (float) (i - j) / (i + c);
            }
        }
        System.out.println("Result: " + s);

    }
}
