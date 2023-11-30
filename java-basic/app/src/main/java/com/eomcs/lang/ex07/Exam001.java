package com.eomcs.lang.ex07;

import java.util.Scanner;

// # 메서드 : 사용 전
//
public class Exam001 {

  public static void printSpaces(int spaceLen) {
    int spaceCnt = 1;
    while (spaceCnt <= spaceLen) {
      System.out.print(" ");
      spaceCnt++;
    }
  }


  static void printStars(int starLen) {
    // 별 출력
    int starCnt = 1;
    while (starCnt <= starLen) {
      System.out.print("*");
      starCnt++;
    }
  }


  static int computeSpaceLength(int len, int starLen) {
    return (len - starLen) / 2;
  }


  static int promptInt(String title) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print(title);
    int len = keyScan.nextInt();
    keyScan.close();

    return len;
  }



  public static void main(String[] args) {
    int len = promptInt("밑변의 길이?");

    for (int starLen = 1; starLen <= len; starLen += 2) {
      // int spaceLen = computeSpaceLength(len, starLen)
      // printSpaces(spaceLen);
      printSpaces(computeSpaceLength(len, starLen));

      printStars(starLen);
      System.out.println();
    }

    // 위 for문을 while 문으로 고친것
    // int starLen = 1;
    // while (starLen <= len) {
    // printSpaces((len - starLen) / 2);
    // printStars(starLen);
    //
    // // 출력 줄 바꾸기
    // System.out.println();
    // starLen += 2;
    // }
  }
}
