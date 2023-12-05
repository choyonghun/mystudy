package mystudy.myapp;

public class BoardMenu {

  static Board Board;

//  public Board(String title, String content, String writer, String createdDate) {
//    this.title = title;
//    this.content = content;
//    this.writer = writer;
//    this.createdDate = createdDate;
//
//  }


  static void printMenu() {
    System.out.println("[게시글]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("0. 이전");
  }

  static void execute() {
    printMenu();

    while (true) {
      String input = Prompt.input("메인/게시글> ");

      switch (input) {
        case "1":
          //System.out.println("등록입니다.");
          add();
          break;
        case "2":
          //System.out.println("조회입니다.");
          view();
          break;
        case "3":
          //System.out.println("변경입니다.");
          modify();
          break;
        case "4":
          //System.out.println("삭제입니다.");
          delete();
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
    System.out.println("게시글 등록> ");
//    title = Prompt.input("제목? ");
//    content = Prompt.input("내용? ");
//    writer = Prompt.input("작성자? ");
//    createdDate = Prompt.input("작성일? ");

    String title = Prompt.input("제목? ");
    String content = Prompt.input("내용? ");
    String writer = Prompt.input("작성자? ");
    String createdDate = Prompt.input("작성일? ");

    Board = new Board(title, content, writer, createdDate);
  }


  static void view() {
    System.out.println("게시글 조회: ");
//    System.out.printf("제목: %s\n", title);
//    System.out.printf("내용: %s\n", content);
//    System.out.printf("작성자: %s\n", writer);
//    System.out.printf("작성일: %s\n", createdDate);

    System.out.printf("제목: %s\n", Board.title);
    System.out.printf("내용: %s\n", Board.content);
    System.out.printf("작성자: %s\n", Board.writer);
    System.out.printf("작성일: %s\n", Board.createdDate);

  }

  static void modify() {
    System.out.println("게시글 변경: ");
//    title = Prompt.input("제목(%s): ", title);
//    content = Prompt.input("내용(%s): ", content);
//    writer = Prompt.input("작성자(%s): ", writer);
//    createdDate = Prompt.input("작성일(%s): ", createdDate);

    Board.title = Prompt.input("제목(%s): ", Board.title);
    Board.content = Prompt.input("내용(%s): ", Board.content);
    Board.writer = Prompt.input("작성자(%s): ", Board.writer);
    Board.createdDate = Prompt.input("작성일(%s): ", Board.createdDate);
  }

  static void delete() {
    Board.title = "";
    Board.content = "";
    Board.writer = "";
    Board.createdDate = "";
  }
}
