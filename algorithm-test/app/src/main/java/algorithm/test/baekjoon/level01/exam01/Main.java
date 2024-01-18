package algorithm.test.baekjoon.level01.exam01;

import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int c = scanner.nextInt();
        int arr[] = new int[c];
        
        for (int i = 0; i < c; i++)  {
          int A = scanner.nextInt();
          int B = scanner.nextInt();
          arr[i] = A + B;
      }
        scanner.close();

      for (int i : arr) {
          System.out.println(i);
      }
   }
}