package mystudy.myapp;

public class MemberMenu {

  //static Member member = new Member();
  static Member[] member = new Member[3];
  static int length = 0;

  static void printMenu() {
    System.out.println("[회원가입]");
    System.out.println("1. 회원 가입");
    System.out.println("2. 회원 조회");
    System.out.println("3. 회원 수정");
    System.out.println("4. 회원 삭제");
    System.out.println("0. 이전");
  }


  static void execute() {
    printMenu();

    while (true) {
      String input = Prompt.input("메인/회원가입> ");

      switch (input) {
        case "1":
          add();
          break;
        case "2":
          list();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "5":
          view();
          break;
        case "0":
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

  static void add() {
    System.out.println("회원 등록");
    member.email = Prompt.input("이메일: ");
    member.name = Prompt.input("이름: ");
    member.password = Prompt.input("비밀번호: ");
    member.joinDate = Prompt.input("가입날짜: ");
  }

  static void list() {
    System.out.println("===회원 조회===");
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("비밀번호: %s\n", member.password);
    System.out.printf("가입날짜: %s\n", member.joinDate);
  }

  static void modify() {

  }

  static void delete() {

  }

  static void view() {

  }
}
