package mystudy.myapp;

import mystudy.menu.MenuGroup;
import mystudy.menu.MenuHandler;
import mystudy.menu.MenuItem;
import mystudy.myapp.menu.BoardAddHandler;
import mystudy.myapp.menu.BoardDeleteHandler;
import mystudy.myapp.menu.BoardListHandler;
import mystudy.myapp.menu.BoardModifywHandler;
import mystudy.myapp.menu.BoardRepository;
import mystudy.myapp.menu.BoardViewHandler;
import mystudy.util.Prompt;

public class App {

  public static void main(String[] args) throws Exception {
    Prompt prompt = new Prompt(System.in);
    //new MainMenu(prompt).execute();

    BoardRepository boardRepository = new BoardRepository();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem("등록"));
    assignmentMenu.add(new MenuItem("조회"));
    assignmentMenu.add(new MenuItem("변경"));
    assignmentMenu.add(new MenuItem("삭제"));
    assignmentMenu.add(new MenuItem("목록"));
    mainMenu.add(assignmentMenu);

    //============================================================================
    MenuGroup boardMenu = new MenuGroup("게시글");
    // 사용자로부터 게시글을 입력 받아서 배열에 저장하는 일을 한다.
    MenuHandler boardAddHandler = new BoardAddHandler(boardRepository, prompt);
    // 등록을 눌럿을때 boardaddhandler를 실행시켜줘라
    MenuItem boardAddMenu = new MenuItem("등록", boardAddHandler);
    // 게시글 등록을 처리하는 메뉴를 게시글 메뉴에 추가한다.
    boardMenu.add(boardAddMenu);

    // 위 3줄을 한줄로 만든것이 지금 밑에 문장이다!
    //boardMenu.add(new MenuItem("등록", new BoardAddHandler());
    boardMenu.add(new MenuItem("조회", new BoardViewHandler()));
    boardMenu.add(new MenuItem("변경", new BoardModifywHandler()));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler()));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository)));
    mainMenu.add(boardMenu);

    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem(("등록")));
    memberMenu.add(new MenuItem(("조회")));
    memberMenu.add(new MenuItem(("변경")));
    memberMenu.add(new MenuItem(("삭제")));
    memberMenu.add(new MenuItem(("목록")));
    mainMenu.add(memberMenu);

    MenuGroup greetingMenu = new MenuGroup("가입인사");
    greetingMenu.add(new MenuItem(("등록")));
    greetingMenu.add(new MenuItem(("조회")));
    greetingMenu.add(new MenuItem(("변경")));
    greetingMenu.add(new MenuItem(("삭제")));
    greetingMenu.add(new MenuItem(("목록")));
    mainMenu.add(greetingMenu);

    MenuGroup helpMenu = new MenuGroup("도움말");
    mainMenu.add(helpMenu);

    mainMenu.execute(prompt);

    prompt.close();
  }
}
