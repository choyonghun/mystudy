package com.eomcs.reflect.ex06.a;

import java.lang.reflect.Proxy;

// Proxy 객체를 만드는 방법
public class Exam0130 {
  public static void main(String[] args) {

    Object obj = Proxy.newProxyInstance(
        Exam0130.class.getClassLoader(), 
        new Class<?>[] {A.class, B.class, C.class}, 
        (proxy, method, params)  -> {
          System.out.println("===> " + method.getName());
          return null;
        });

    ((A) obj).m1();
    ((B) obj).m2();
    ((C) obj).m3();

  }
}
