package com.eomcs.oop.ex02.step12;

// ## 사용자 정의 데이터 타입 만들기
// 학생의 성적 데이터를 담을 전용 메모리(변수)를 설계한다.
// 학생 데이터를 묶음으로 다룰 수 있도록 변수 그룹을 정의한다.
public class Score {
  
  // 인스턴스 변수
  // new 명령어로 생성되는 변수이다.
  // 데이터를 개별적으로 다루고 싶을 때 인스턴스 변수로 선언한다.
  
  // 새 데이터 타입 정의
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  
  static void compute(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
  }
}
