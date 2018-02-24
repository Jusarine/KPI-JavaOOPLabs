package Lab2;

import java.util.Random;
import java.util.Scanner;

public class Lab2 {
    public static int na, ma, nb, mb;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n for matrix A:");
        na = sc.nextInt();
        System.out.println("Enter m for matrix A:");
        ma = sc.nextInt();

        System.out.println("Enter n for matrix B:");
        nb = sc.nextInt();
        System.out.println("Enter m for matrix B:");
        mb = sc.nextInt();
        sc.close();

        System.out.println();
        System.out.println("Matrix A:");
        byte[][] a = generateMatrix(na, ma);
        System.out.println("Matrix B:");
        byte[][] b = generateMatrix(nb, mb);

        System.out.println("Matrix C:");
        byte[][] c = multiply(a, na, ma, b, nb, mb);

        calcAverage(c, na, mb);

    }

    public static void calcAverage(byte[][] matrix, int n, int m){
        int sum = 0;
        for (byte[] arr : matrix) {
            for (byte elem : arr) {
                sum += elem;
            }
        }
        System.out.println("Average = " + sum / (m * n));

    }

    public static byte[][] multiply(byte[][] a, int na, int ma, byte[][] b, int nb, int mb){

        if (ma != nb) throw new ArithmeticException("N in matrix A must be equal m in matrix B!");

        byte[][] c = new byte[na][mb];
        for (int i = 0; i < na; i++){
            for (int k = 0; k < mb; k++){
                byte sum = 0;
                for (int j = 0; j < nb; j++){
                     sum += (byte) (a[i][j] * b[j][k]);
                }
                c[i][k] = sum;
                System.out.print(c[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return c;
    }

    public static byte[][] generateMatrix(int n, int m){
        Random random = new Random();

        byte[][] matrix = new byte[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix[i][j] = (byte) random.nextInt(10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return matrix;
    }

}
