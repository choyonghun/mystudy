package mystudy.myapp;

public class MemberMenu {

  //static Member member = new Member();
  static Member[] members = new Member[3];
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
    if (length == members.length) {
      System.out.println("회원 등록을 더이상 할수 없습니다.");
      int oldSize = members.length;
      int newSize = oldSize + (oldSize / 2);

      Member[] arr = new Member[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = members[i];
      }
      members = arr;
    }

    Member member = new Member();
    member.email = Prompt.input("이메일: ");
    member.name = Prompt.input("이름: ");
    member.password = Prompt.input("비밀번호: ");
    member.joinDate = Prompt.input("가입날짜: ");

    members[length++] = member;
  }

  static void list() {
    System.out.println("===회원 조회===");
    System.out.printf("%-20s\t%-10s\t%-10s\t%-10s\n", "이메일", "이름", "비밀번호", "가입날짜");

    for (int i = 0; i < length; i++) {
      Member member = members[i];
      System.out.printf("%-20s\t%-10s\t%-10s\t%-10s\n", member.email, member.name, member.password,
          member.joinDate);
    }
  }

  static void view() {
    System.out.println("회원 조회: ");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("조회할 회원이 없습니다.");
      return;
    }

    Member member = members[index];
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("비밀번호: %s\n", member.password);
    System.out.printf("가입날짜: %s\n", member.joinDate);
    System.out.println("-------------------------------");
  }

  static void modify() {
    System.out.println("회원 수정: ");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("수정할 회원이 없습니다.");
      return;
    }

    Member member = members[index];
    member.email = Prompt.input("이메일(%s): ", member.email);
    member.name = Prompt.input("이름(%s): ", member.name);
    member.password = Prompt.input("비밀번호(%s): ", member.password);
    member.joinDate = Prompt.input("가입날짜(%s): ", member.joinDate);
  }

  static void delete() {
    System.out.println("회원 삭제");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("삭제할 회원이 없습니다");
      return;
    }

    for (int i = index; i < (length - 1); i++) {
      members[i] = members[i + 1];
    }
    members[--length] = null;
  }
}
