// Object 클래스 - getClass() : 해당 클래스의 정보를 리턴한다.
package com.eomcs.basic.ex01;


public class Exam0161 {

  public static void main(String[] args) {
    
    // primitive Type은 Object의 서브 클래스가 아니기 때문에 getClass()를 호출할수 없다.
    // 그러나 stataic 변수인 class 를 사용하여  Class 정보를 리턴 받을수 있다.
     
    Class classInfo = byte.class;
    System.out.println(classInfo.getName());
    System.out.println(short.class.getName());
    System.out.println(char.class.getName());
    System.out.println(int.class.getName());
    System.out.println(long.class.getName());
    System.out.println(float.class.getName());
    System.out.println(double.class.getName());
    System.out.println(boolean.class.getName());

    System.out.println(String.class.getName());

  }
}







