//package mystudy.myapp.handler;
//
//import mystudy.menu.Menu;
//import mystudy.util.AnsiEscape;
//import mystudy.util.Prompt;
//
//public class MainMenu implements Menu {
//
//  static final String APP_TITLE =
//      AnsiEscape.ANSI_BOLD_RED
//          + "[과제관리 시스템]"
//          + AnsiEscape.ANSI_CLEAR;
//  static final String[] MENUS = {
//      "1. 과제",
//      "2. 게시글",
//      "3. 회원",
//      "4. 가입인사",
//      "5. 도움말",
//      AnsiEscape.ANSI_RED + "0. 종료" + AnsiEscape.ANSI_CLEAR
//  };
//
//  // 의존 객체(Dependency Object ==> dependency);
//  // - 클래스가 작업을 수행할 때 사용하는 객체
//  Prompt prompt;
//
//  public MainMenu(Prompt prompt) {
//    this.prompt = prompt;
//  }
//
//  static void printMenu() {
//    System.out.println(APP_TITLE);
//    System.out.println();
//    for (String menu : MENUS) {
//      System.out.println(menu);
//    }
//  }
//
//  @Override
//  public String getTitle() {
//    return null;
//  }
//
//  public void execute(Prompt prompt) {
//
//    Menu boardMenu = new BoardMenu("게시판", this.prompt);
//    Menu greetingMenu = new BoardMenu("가입인사", this.prompt);
//    Menu assignmentMenu = new AssignmentMenu("과제", this.prompt);
//    Menu memberMenu = new MemberMenu("회원", this.prompt);
//    Menu helpMenu = new HelpMenu("도움말", this.prompt);
//
//    printMenu();
//
//    while (true) {
//      String input = this.prompt.input("메인> ");
//
//      switch (input) {
//        case "1":
//          assignmentMenu.execute(prompt);
//          break;
//        case "2":
//          boardMenu.execute(prompt);
//          break;
//        case "3":
//          memberMenu.execute(prompt);
//          break;
//        case "4":
//          greetingMenu.execute(prompt);
//          break;
//        case "5":
//          helpMenu.execute(prompt);
//          break;
//        case "0":
//          System.out.println("종료합니다.");
//          return;
//        case "menu":
//          printMenu();
//          break;
//        default:
//          System.out.println("메뉴 번호가 옳지 않습니다.");
//      }
//    }
//  }
//}
