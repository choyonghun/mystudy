package com.eomcs.oop.ex02.testtest;

public class App {
  public static void main(String[] args) {
    Score s1 = new Score("홍길동", 100, 90, 85);
    Score s2 = new Score("임꺽정", 90, 80, 75);
    Score s3 = new Score("유관순", 80, 70, 65);


//    s1.name = "홍길동";
//    s1.kor = 100;
//    s1.eng = 90;
//    s1.math = 85;
//    s1.compute(s1);
//
//
//    s2.name = "임꺽정";
//    s2.kor = 90;
//    s2.eng = 80;
//    s2.math = 75;
//    s2.compute(s2);
//
//    s3.name = "유관순";
//    s3.kor = 80;
//    s3.eng = 70;
//    s3.math = 65;
//    s3.compute(s3);
    
    
    printScore(s1);
    printScore(s2);
    printScore(s3);
  }
  
  static void printScore(Score s) {

    // 암시적 형변환이 일어난다.
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}
