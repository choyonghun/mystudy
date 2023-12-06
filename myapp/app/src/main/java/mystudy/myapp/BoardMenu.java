package mystudy.myapp;

public class BoardMenu {

  //static Board board = new Board(); 를 사용하면 여러개를 담을수없다!!
  //new Board[2] 이면 0, 1 2개만 담는다는 뜻이다.
  static Board[] boards = new Board[2];

  static int length = 0;
  // static int length; 라고해도 초기화 된다!!


  static void printMenu() {
    System.out.println("[게시글]");
    System.out.println("1. 등록");
    System.out.println("2. 조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  static void execute() {
    printMenu();

    while (true) {
      String input = Prompt.input("메인/게시글> ");

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
    System.out.println("게시글 등록> ");

    if (length == boards.length) {    // 배열이 꽉찼다면
      System.out.println("게시글을 더이상 등록할수 없습니다.");
      //return으로 보내거나, 배열을 1.5개씩 증가시켜준다.
      int oldSize = boards.length;
      int newSize = oldSize + (oldSize / 2);
      //int newSize = oldSize + (oldSize >> 1);   1비트 이동시킨다. 2로 나눈다

      //새로운 크기의 newSize 배열을 만든다
      //boards 안에있는 요소를 새로운 배열 arr[]에 그대로 집어넣는다.
      //boards = arr 는 그대로 복사가 되어 확장된 배열에 참조된다.
      Board[] arr = new Board[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = boards[i];
      }
      boards = arr;
    }

    Board board = new Board();  //보드 객체를 만들어준다!! heap메모리에 저장됨
    board.title = Prompt.input("제목? ");
    board.content = Prompt.input("내용? ");
    board.writer = Prompt.input("작성자? ");
    board.createdDate = Prompt.input("작성일? ");

    boards[length] = board;   // boards의 배열의 length->0번째에 board를 저장시킨다.
    length++;                 // length 1씩 증가   0으로 초기화 했으니 0부터 출발
    //boards [length++] = board; 로도 작성 가능하다!!
  }


  static void list() {
    System.out.println("게시글 조회: ");
    System.out.printf("%-20s\t%-10s\t%-10s\n", "제목", "작성자", "작성일");
    System.out.println("-----------------------------------------------");

    for (int i = 0; i < length; i++) {
      Board board = boards[i];
      System.out.printf("%-20s\t%-20s\t%-20s\n", board.title, board.writer, board.createdDate);
    }
  }

  static void view() {
    System.out.println("게시글 조회: ");
    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("게시글이 유효하지 않습니다.");
      return;
    }

    // board의 index 번호를 가져온다.
    Board board = boards[index];
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("작성일: %s\n", board.createdDate);
    System.out.println("----------------------------");
  }


  static void modify() {
    System.out.println("게시글 변경: ");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index >= length) {
      System.out.println("해당 게시글이 유효하지 않습니다.");
      return;
    }

    Board board = boards[index];
    board.title = Prompt.input("제목(%s): ", board.title);
    board.content = Prompt.input("내용(%s): ", board.content);
    board.writer = Prompt.input("작성자(%s): ", board.writer);
    board.createdDate = Prompt.input("작성일(%s): ", board.createdDate);
  }

  static void delete() {
    System.out.println("게시글 삭제");

    int index = Integer.parseInt(Prompt.input("번호? "));
    if (index < 0 || index > length) {
      System.out.println("해당 게시글 번호가 유효하지 않습니다.987");
      return;
    }

    //0있는 값을 없애고 1에있는 값을 0로 가져온다
    //index 값을 넣어줄때 [5] 인데 index에 5가 들어가면 안된다.
    //board[5]=board[6]이 되는데 5까지 밖에 만들지 않아 board[6]은 들어갈수 없다.
    for (int i = index; i < (length - 1); i++) {
      boards[i] = boards[i + 1];
    }
    //for문에 맞는다면 [2]자리에 [3]이 들어가게 되어 하나씩 땡겨지게 된다.
    --length;
    //맨 마지막 값은 없앤다 = null 적어주면 없어진다.
    //boards[length] 는 문자열이기 때문에 0이 적힐수 없어 초기화 시키려면 null을 적어준다.
    boards[length] = null;
  }
}
