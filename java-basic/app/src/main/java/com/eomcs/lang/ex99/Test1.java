package com.eomcs.lang.ex99;

import java.io.InputStream;

public class Test1 {

  public static void main(String[] args) throws Exception {
    InputStream in = System.in;

    // java.util 을 import 하지 않을꺼면 이렇게 작성해준다
    java.util.Scanner keyIn = new java.util.Scanner(in);

    // Scanner 정보를 가져와야하는데 in 메모리를 가져오면 사용 불가능하다.
    // in.nextLine() 은 사용할수 없다.
    // Scanner 정보를 가지고 있는 메모리 keyIn을 가져와야한다.

    String str = keyIn.nextLine();
    System.out.println("===> " + str);

    // 사용후 잠그는 것을 습관화 하기
    keyIn.close();
  }
}
