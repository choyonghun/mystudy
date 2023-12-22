package mystudy.myapp;

import java.util.ArrayList;
import mystudy.menu.MenuGroup;
import mystudy.menu.MenuHandler;
import mystudy.menu.MenuItem;
import mystudy.myapp.handler.assignment.AssignmentAddHandler;
import mystudy.myapp.handler.assignment.AssignmentDeleteHandler;
import mystudy.myapp.handler.assignment.AssignmentListHandler;
import mystudy.myapp.handler.assignment.AssignmentModifyHandler;
import mystudy.myapp.handler.assignment.assignmentViewHandler;
import mystudy.myapp.handler.board.BoardAddHandler;
import mystudy.myapp.handler.board.BoardDeleteHandler;
import mystudy.myapp.handler.board.BoardListHandler;
import mystudy.myapp.handler.board.BoardModifyHandler;
import mystudy.myapp.handler.board.BoardViewHandler;
import mystudy.myapp.handler.member.MemberAddHandler;
import mystudy.myapp.handler.member.MemberDeleteHandler;
import mystudy.myapp.handler.member.MemberListHandler;
import mystudy.myapp.handler.member.MemberModifyHandler;
import mystudy.myapp.handler.member.MemberViewHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.myapp.vo.Board;
import mystudy.myapp.vo.Member;
import mystudy.util.Prompt;

public class App {

  public static void main(String[] args) throws Exception {
    Prompt prompt = new Prompt(System.in);
    //new MainMenu(prompt).execute();

    ArrayList<Board> objectRepository = new ArrayList<>();
    ArrayList<Assignment> assignmentRepository = new ArrayList<>();
    ArrayList<Member> memberRepository = new ArrayList<>();
    ArrayList<Board> greetingRepository = new ArrayList<>();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem("등록", new AssignmentAddHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("조회", new assignmentViewHandler(assignmentRepository, prompt)));
    assignmentMenu.add(
        new MenuItem("변경", new AssignmentModifyHandler(assignmentRepository, prompt)));
    assignmentMenu.add(
        new MenuItem("삭제", new AssignmentDeleteHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("목록", new AssignmentListHandler(assignmentRepository, prompt)));
    mainMenu.add(assignmentMenu);

    //============================================================================
    MenuGroup boardMenu = new MenuGroup("게시글");
    // 사용자로부터 게시글을 입력 받아서 배열에 저장하는 일을 한다.

    MenuHandler boardAddHandler = new BoardAddHandler(objectRepository, prompt);
    // 등록을 눌럿을때 boardaddhandler를 실행시켜줘라
    MenuItem boardAddMenu = new MenuItem("등록", boardAddHandler);
    // 게시글 등록을 처리하는 메뉴를 게시글 메뉴에 추가한다.
    boardMenu.add(boardAddMenu);
    // 위 3줄을 한줄로 만든것이 지금 밑에 문장이다!
    //boardMenu.add(new MenuItem("등록", new BoardAddHandler());
    boardMenu.add(new MenuItem("조회", new BoardViewHandler(objectRepository, prompt)));
    boardMenu.add(new MenuItem("변경", new BoardModifyHandler(objectRepository, prompt)));
//    BoardModifywHandler handler = new BoardModifywHandler(boardRepository, prompt);
//    MenuItem menuItem = new MenuItem("변경", handler);
//    boardMenu.add(menuItem);
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler(objectRepository, prompt)));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(objectRepository, prompt)));
    mainMenu.add(boardMenu);

    //============================================================================
    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem("등록", new MemberAddHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("조회", new MemberViewHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("변경", new MemberModifyHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("삭제", new MemberDeleteHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("목록", new MemberListHandler(memberRepository, prompt)));
    mainMenu.add(memberMenu);

    //============================================================================
    MenuGroup greetingMenu = new MenuGroup("가입인사");
    greetingMenu.add(new MenuItem(("등록")));
    greetingMenu.add(new MenuItem(("조회")));
    greetingMenu.add(new MenuItem(("변경")));
    greetingMenu.add(new MenuItem(("삭제")));
    greetingMenu.add(new MenuItem(("목록")));
    mainMenu.add(greetingMenu);

    MenuGroup helpMenu = new MenuGroup("도움말");
    mainMenu.add(helpMenu);

    // 프로그램을 실행하다가 어느 지점에서 예외가 발생하면 해당 위치에서 적절한 조치를 취할것이다.
    // 다만 그에 벗어나서 조치가 되지 않은 예외가 보고 되는 경우를 대비해
    // 마지막 보루인 main()에서는 예외를 처리해야 한다.
    // main()에서 마저 처리하지 않는다면 JVM에게 보고 될것이고,
    // JVM은 개발자나 알아 볼 메세지를 출력하고 종료할 것이다.
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생@!!@!@!");
        return;
      }
    }
  }
}
