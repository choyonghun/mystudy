// 메서드 레퍼런스 - 활용예
package com.eomcs.oop.ex12;

import java.util.function.Predicate;

public class Exam0640 {

  static class My {
    public boolean test() {
      return true;
    }
  }
  
  public static void main(String[] args) {

//    interface Predicate<T>  {
//      boolean test( T value);
//    }
    
    //Predicate<String> p1 = My::m;     //ok
    // 1) My의 test()는 스태틱 메서드가 아니다.   ->  인스턴스 메서드 이다   /  
    // 2) My의 test()는 String 파라미터가 없다.
//    
//    My obj = new My();
//    Predicate<String> p2 = obj::m;   // 컴파일 오류
    // 1) My의 test()는 String 파라미터를 못 받는다.
    
    
    // Predicate<String> p3 = My::m;           // 안됨
    
    // 기존의 My의 m()을 test() 메서드를 구현하는데 사용하는 방법
    Predicate<My> obj = (My value) -> { return value.m(); };
    
    // 코드를 좀 더 줄이기 - 바로 위의 코드를 작성하는 경우가 많다 보니 다음과 같은 단축 문법이 등장
    Predicate<My> obj2 = (My value) -> value.m();
    
    // 코드를 더 줄이기
    Predicate<My> obj3 = My::m;    // OK!      
    
    // 위와 같이 단축 문법을 사용하려면,
    // ==> 타입 파라미터의 클래스가 인스턴스 메서드의 클래스랑 같아야 한다.
    // 다음과 같이 람다 문법으로 변경된다.
    // => Predicate<My> p3 = (My value) -> { return value.m(); };
    
    obj3.test(new My());

  }
}

