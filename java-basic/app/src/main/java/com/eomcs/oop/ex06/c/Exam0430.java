// 오버라이딩(overriding) - 준비
package com.eomcs.oop.ex06.c;



public class Exam0430 {

  static class A {
    String name = "A";
    boolean working = true;

    void print() {
      System.out.println("A.print():");
      System.out.printf("  => this.name(%s)\n", this.name);
      System.out.printf("  => this.working(%s)\n", this.working);
    }
    void m1() {
      System.out.println("A.m1()");
    }
  }


  static class A2 extends A {
    String name ="A2";
    int age = 20;

    @Override
    void print() {
      System.out.println("A2.print():");
      System.out.printf("  => this.name(%s), super.name(%s)\n",
          this.name, super.name);
      System.out.printf("  => this.working(%s), super.working(%s)\n",
          this.working, super.working);
      System.out.printf("  => this.age(%s), super.age(컴파일 오류!) \n",
          this.age /*, super.age*/);
      
      this.m1();
      super.m1();
    }
    @Override
    void m1() {
      System.out.println("A2.m1()");
    }
  }


  static class A3 extends A2 {
    String name ="A3";

    @Override
    void m1() {
      System.out.println("A3.m1()");
    }
  }


  public static void main(String[] args) {
    A2 obj = new A2();
    obj.print();
//    A obj1 = new A();
//    obj1.print();
//    System.out.println("--------------------------------");
//
//    A2 obj2 = new A2();
//    obj2.print();
//    System.out.println("--------------------------------");
//
//    A3 obj3 = new A3();
//    obj3.print();
//    System.out.println("--------------------------------");
//
//    A4 obj4 = new A4();
//    obj4.print();
//    System.out.println("--------------------------------");
//
//    A3 obj5 = new A4();
//    obj5.print();
//    // 레퍼런스가 실제 자식 객체를 가리킨다면,
//    // 메서드를 찾을 때 자식 클래스의 오버라이딩 메서드를 먼저 찾는다.
//    // 따라서 obj5의 print()는 실제 obj5가 가리키는 A4의 print()를 호출한다.
//    System.out.println("--------------------------------");
////
//    obj5.print2(); // A.print2();
//    System.out.println("--------------------------------");
  }
}
