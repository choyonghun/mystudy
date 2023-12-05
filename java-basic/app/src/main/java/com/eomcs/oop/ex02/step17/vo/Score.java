package com.eomcs.oop.ex02.step17.vo;

// ## 사용자 정의 데이터 타입 만들기
// 학생의 성적 데이터를 담을 전용 메모리(변수)를 설계한다.
// 학생 데이터를 묶음으로 다룰 수 있도록 변수 그룹을 정의한다.
public class Score {
  
  // 인스턴스 변수
  // new 명령어로 생성되는 변수이다.
  // 데이터를 개별적으로 다루고 싶을 때 인스턴스 변수로 선언한다.
  
  // 새 데이터 타입 정의
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;
  
  // Score 데이터 값으 다루는 메서드는 Score 데이터를 선언한 클래스에 가까이 두는것이
  // 유지보수에 좋다
  // GRASP 패턴의 'information Expert' 설계 기법을 적용한 예이다.
  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}
//앞에 static 지우고 this로 넣어준다.
// public 을 붙여줘야 다른 패키지에서 공개가 가능하다