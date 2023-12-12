package algorithm.test.baekjoon.level01.exam01;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int A, B;
        do {
            A = sc.nextInt();
        } while (A <= 1);
        do {
            B = sc.nextInt();
        } while (B >= 10000);
        
        System.out.println(A + B);
        System.out.println(A - B);
        System.out.println(A * B);
        System.out.println(A / B);
        System.out.println(A % B);
    }
}


