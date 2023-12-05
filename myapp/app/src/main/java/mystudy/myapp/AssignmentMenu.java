package mystudy.myapp;

public class AssignmentMenu {

  static Project Project;

//  static String title;
//  static String content;
//  static String deadline;


  static void printMenu() {
    System.out.println("[과제]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }

  static void execute() {
    AssignmentMenu.printMenu();

    while (true) {
      String input = Prompt.input("메인/과제> ");

      switch (input) {
        case "1":
          add();
          break;
        case "2":
          view();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "0":
          return;
        case "menu":
          AssignmentMenu.printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }
  }

  static void add() {
    System.out.println("과제 등록: ");
//    title = Prompt.input("과제명? ");
//    content = Prompt.input("내용? ");
//    deadline = Prompt.input("제출 마감일? ");

    String title = Prompt.input("제목? ");
    String content = Prompt.input("내용? ");
    String deadline = Prompt.input("제출 마감일? ");

    Project = new Project(title, content, deadline);
  }

  static void view() {
    System.out.println("과제 조회: ");
//    System.out.printf("과제명: %s\n", title);
//    System.out.printf("내용: %s\n", content);
//    System.out.printf("제출 마감일: %s\n", deadline);

    System.out.printf("제목: %s\n", Project.title);
    System.out.printf("내용: %s\n", Project.content);
    System.out.printf("제출 마감일: %s\n", Project.deadline);
  }

  static void modify() {
    System.out.println("과제 변경: ");
//    title = Prompt.input("과제명(" + title + ")? ");
//    content = Prompt.input("내용(" + content + ")? ");
//    deadline = Prompt.input("제출 마감일(" + deadline + ")? ");

//    title = Prompt.input(String.format("과제명(%s): ", title));
//    content = Prompt.input(String.format("내용(%s): ", content));
//    deadline = Prompt.input(String.format("제출 마감일(%s): ", deadline));

//    title = Prompt.input("과제명(%s): ", title);
//    content = Prompt.input("내용(%s): ", content);
//    deadline = Prompt.input("제출 마감일(%s): ", deadline);

    Project.title = Prompt.input("제목(%s): ", Project.title);
    Project.content = Prompt.input("제목(%s): ", Project.content);
    Project.deadline = Prompt.input("제목(%s): ", Project.deadline);
  }

  static void delete() {
    System.out.println("삭제입니다.");
    Project.title = "";
    Project.content = "";
    Project.deadline = "";
  }
}
