package com.eomcs.oop.ex02.step11;

//데이터 타입 정의
//0) 클래스 사용 전 낱개 변수 사용
//1) 성적 데이터를 저장할 메모리를 새로 정의 : 
//    ==>    '사용자 정의( user-defined data type ) 데이터 타입'이라 부른다.
// 여러 개로 이루어진 데이터를 한 묶음으로 다루면 관리하기가 쉽다.
//
public class App {
  public static void main(String[] args) {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    name = "홍길동";
    kor = 100;
    eng = 90;
    math = 85;
    sum = kor + eng + math;
    aver = (float) sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);

    name = "임꺽정";
    kor = 90;
    eng = 80;
    math = 75;
    sum = kor + eng + math;
    aver = (float) sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);

    name = "유관순";
    kor = 80;
    eng = 70;
    math = 65;
    sum = kor + eng + math;
    aver = (float) sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);
  }
}
