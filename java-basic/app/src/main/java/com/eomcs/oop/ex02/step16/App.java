package com.eomcs.oop.ex02.step16;

//데이터 타입 정의
//0) 클래스 사용 전 낱개 변수 사용
//1) 성적 데이터를 저장할 메모리를 새로 정의 : 
//    ==>    '사용자 정의( user-defined data type ) 데이터 타입'이라 부른다.
// 여러 개로 이루어진 데이터를 한 묶음으로 다루면 관리하기가 쉽다.
//2) 리팩토링
//      - 메서드 추출(extract method): 중복되는 코드가 있으면 별도의 메서드로 분리한다.
//3) 리팩토링
//      - 메서드 추출(extract method): 한 개의 메서드는 한개의 기능을 수행해야 한다.
//4) GRASP (General Responsibility Assignment Software Patterns) 패턴
//      - Information Expert: 데이터를 다룰 때는 그 데이터를 갖고 있는 객체에게 묻는다.
//      - 리팩토링 : 메서드 이동 (Move Method)
//          -메서드를 관련된 클래스로 이동시킨다. => 코드의 이해가 쉽다.
//5) 인스턴스 메서드
//      - 
public class App {
  public static void main(String[] args) {
    // 사용자 정의 데이터 타입을 사용하는 방법
    // new 명령을 사용하여 설계도에 기술된 대로 메모리(변수)를 준비한다
    // 변수는 Heap 영역에 생성된다.
    // 변수들이 생성된 메모리의 주소를 레퍼런스(주소 변수)에 저장된다.
    Score s1 = new Score();
    Score s2 = new Score();
    Score s3 = new Score();
    
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;
    //Score에 compute가 있으니 s1을 넣어서 계산하면 출력된다.
    s1.compute();
//    s1.sum = s1.kor + s1.eng + s1.math;
//    s1.aver = (float) s1.sum / 3;

    // Heap 영역에 생성된 인스턴스의 변수는 레퍼런스를 통해 접근한다.
    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 80;
    s2.math = 75;
    s2.compute();
//    s2.sum = s2.kor + s2.eng + s2.math;
//    s2.aver = (float) s2.sum / 3;


    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 70;
    s3.math = 65;
    s3.compute();
//    s3.sum = s3.kor + s3.eng + s3.math;
//    s3.aver = (float) s3.sum / 3;
   
    printScore(s1);
    printScore(s2);
    printScore(s3);

//    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.aver);
//    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s2.name, s2.kor, s2.eng, s2.math, s2.sum, s2.aver);
//    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s3.name, s3.kor, s3.eng, s3.math, s3.sum, s3.aver);
  }
  
  // printScore은 출력 기능만 담당하도록 한다.
  static void printScore(Score s) {
    // 암시적 형변환이 일어난다.
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
    
  }
}
