// stateless 방식에서 클라이언트를 구분하고 작업 결과를 유지하는 방법
package com.eomcs.net.ex04.stateless2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.print("연산자? ");
      String op = keyScan.nextLine();

      System.out.print("값? ");
      int value = Integer.parseInt(keyScan.nextLine());

      try (Socket socket = new Socket("localhost", 8888);
          Scanner in = new Scanner(socket.getInputStream());
          DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

        out.writeUTF(op);
        out.writeInt(value);

        String str = in.nextLine();
        System.out.println(str);

      } catch (Exception e) {
        System.out.println("서버와 통신 중 오류 발생!");
      }

      System.out.print("계속하시겠습니까?(Y/n)");
      if (keyScan.nextLine().equalsIgnoreCase("n")) {
        break;
      }
    }

    keyScan.close();
  }
}