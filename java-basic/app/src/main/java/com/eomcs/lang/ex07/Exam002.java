package com.eomcs.lang.ex07;

import java.util.Scanner;

// # 메서드 : 사용 전
//
public class Exam002 {

  public static void printSpaces(int spaceLen) {
    int spaceCnt = 1; // 변수 1로 초기화
    while (spaceCnt <= spaceLen) { // spaceCnt가 spaceLen보다 작거나 같은동안 반복한다
      System.out.println(" "); // 반복할때 한번의 공백을 출력한다.
      spaceCnt++;
    }
  }

  static void printStars(int starLen) {
    // 별출력
    int starCnt = 1; // 변수 1로 초기화
    while (starCnt <= starLen) { // starCnt가 starLen보다 크거나 같으면 반복한다.
      System.out.println("*"); // 반복하는동안 *를 출력시킨다.
      starCnt++; // 1개씩 증가
    }
  }

  static int computeSpaceLength(int len, int starLen) {
    return (len - starLen) / 2; // 전체길이Len - 별길이starLen / 2
  }

  static int promptInt(String title) {
    Scanner scanner = new Scanner(System.in); // 직접 적는 란
    System.out.println(title); // title = "밑변의 길이"를 가져와서 출력
    int len = scanner.nextInt(); // 내가 적는 숫자
    scanner.close(); // scanner 종료
    return len; // len으로 리턴
  }



  public static void main(String[] args) {
    int len = promptInt("밑변의 길이"); // promptInt의 tilte = 밑변의길이 라 title로 가서 출력

    // starLen을 1부터 시작하여 2씩 증가시키면서 len보다 작거나 같은 동안 반복합니다.
    // 이는 각 줄에 출력되는 별의 개수를 조절하기 위한 루프입니다.
    // starLen += 2를 통해 홀수 개수의 별을 출력합니다.
    // printSpaces의 클래스 변수에 computeSpaceLength를 넣어주어 계산한다.
    // printStars의 클래스 변수에 for문에서 계산한 StarLen을 넣어준다.
    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpaces(computeSpaceLength(len, starLen));
      printStars(starLen);
      System.out.println();
    }
  }

  // Scanner keyScan = new Scanner(System.in);
  // System.out.print("밑변의 길이? ");
  // int len = keyScan.nextInt();
  // keyScan.close();
  //
  // int starLen = 1;
  // while (starLen <= len) {
  // // 별 앞에 공백 출력
  // int spaceCnt = 1;
  // int spaceLen = (len - starLen) / 2;
  // while (spaceCnt <= spaceLen) {
  // System.out.print(" ");
  // spaceCnt++;
  // }
  //
  // // 별 출력
  // int starCnt = 1;
  // while (starCnt <= starLen) {
  // System.out.print("*");
  // starCnt++;
  // }
  //
  // // 출력 줄 바꾸기
  // System.out.println();
  // starLen += 2;
  // }
  // }
}
