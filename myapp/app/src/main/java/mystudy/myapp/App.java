package mystudy.myapp;

import java.util.Scanner;

public class App {

  static final String ANSI_CLEAR = "\033[0m";            // 초기화
  static final String ANSI_BOLD_RED = "\033[1;31m";      // 볼드체 + 빨간색글씨
  static final String ANSI_RED = "\033[0;31m";           // 빨간색글씨
  static final String APP_TITLE = ANSI_BOLD_RED + "[과제관리 시스템]" + ANSI_CLEAR;
  static final String[] MENUS = {
      "1. 과제",
      "2. 게시글",
      "3. 도움말",
      ANSI_RED + "4. 종료" + ANSI_CLEAR
  };

  public static void main(String[] args) {

    // 메서드 하나로 20줄 넘는 것을 한줄로 처리가능하다!!
    printMenu();

    Scanner scanner = new Scanner(System.in);

    loop:
    while (true) {
      String input = prompt(scanner);

      switch (input) {
        case "1":
          System.out.println("과제입니다.");
          break;
        case "2":
          System.out.println("게시글입니다.");
          break;
        case "3":
          System.out.println("도움말입니다.");
          break;
        case "4":
          System.out.println("종료합니다.");
          break loop;
        case "menu":
          // 코드를 기능 단위로 묶어 메서드로 정의하면
          // 메서드의 이름을 통해 해당 기능을 쉽게 유추할수 있어 유지보수에 좋다.
          printMenu();
          break;
        default:
          System.out.println("올바른번호를 입력하십시오.");
      }
    }
    scanner.close();
  }

  static void printMenu() {
    // ANSI 코드와 App 제목, 메뉴를 저장한 변수를 메서드 안에 두는 대신에
    // 클래스 블록안에 두면
    // printMenu()를 호출할때마다 변수를 만들기 않기 때문에 실행 속도나 메모리 부분에서
    // 훨씬 효율적이다.
    // 보통 메서드 호출 될때 마다 값이 바뀌는 변수가 아니라 고정 값을 같는 변수인 경우
    // 메서드 밖에 두는 것이 좋다.
    //
    System.out.println(ANSI_BOLD_RED + APP_TITLE + ANSI_CLEAR);
    System.out.println();

    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }

  static String prompt(Scanner scanner) {
    System.out.print("> ");
    return scanner.nextLine();
  }
}