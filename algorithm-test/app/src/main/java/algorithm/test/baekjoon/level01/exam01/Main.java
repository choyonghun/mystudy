package algorithm.test.baekjoon.level01.exam01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

      Scanner scanner = new Scanner(System.in);

      System.out.print("첫 번째 정수 A 입력: ");
      int A = scanner.nextInt();

      System.out.print("두 번째 정수 B 입력: ");
      int B = scanner.nextInt();

      int sum = A + B;
      System.out.println("A + B = " + sum);

      scanner.close();
  }
}
