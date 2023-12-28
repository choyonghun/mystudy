package mystudy.myapp;

import mystudy.menu.MenuGroup;
import mystudy.myapp.handler.HelpHandler;
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
import mystudy.util.ArrayList;
import mystudy.util.LinkedList;
import mystudy.util.List;
import mystudy.util.Prompt;
import mystudy.util.Stack;

public class App {

  public static void main(String[] args) throws Exception {
    Prompt prompt = new Prompt(System.in);
    //new MainMenu(prompt).execute();

    List<Board> objectRepository = new LinkedList<>();
    List<Assignment> assignmentRepository = new LinkedList<>();
    List<Member> memberRepository = new ArrayList<>();
    List<Board> greetingRepository = new LinkedList<>();

    //메뉴의 경로를 저장할 스택 객체 준비
    Stack<String> breadcrumb = new Stack<>();

    MenuGroup mainMenu = MenuGroup.getInstance("메인");

    MenuGroup assignmentMenu = mainMenu.addGroup("과제");
    assignmentMenu.addItem("등록", new AssignmentAddHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("조회", new assignmentViewHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("변경", new AssignmentModifyHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("목록", new AssignmentListHandler(assignmentRepository, prompt));

    //============================================================================
    MenuGroup boardMenu = mainMenu.addGroup("게시글");
    // 사용자로부터 게시글을 입력 받아서 배열에 저장하는 일을 한다.

    boardMenu.addItem("등록", new BoardAddHandler(objectRepository, prompt));
    boardMenu.addItem("조회", new BoardViewHandler(objectRepository, prompt));
    boardMenu.addItem("변경", new BoardModifyHandler(objectRepository, prompt));
//    BoardModifywHandler handler = new BoardModifywHandler(boardRepository, prompt);
//    MenuItem menuItem = new MenuItem("변경", handler);
//    boardMenu.add(menuItem);
    boardMenu.addItem("삭제", new BoardDeleteHandler(objectRepository, prompt));
    boardMenu.addItem("목록", new BoardListHandler(objectRepository, prompt));

    //============================================================================
    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(memberRepository, prompt));
    memberMenu.addItem("조회", new MemberViewHandler(memberRepository, prompt));
    memberMenu.addItem("변경", new MemberModifyHandler(memberRepository, prompt));
    memberMenu.addItem("삭제", new MemberDeleteHandler(memberRepository, prompt));
    memberMenu.addItem("목록", new MemberListHandler(memberRepository, prompt));

    //============================================================================
    MenuGroup greetingMenu = mainMenu.addGroup("가입인사");
    greetingMenu.addItem("등록", new BoardAddHandler(greetingRepository, prompt));
    greetingMenu.addItem("조회", new BoardViewHandler(greetingRepository, prompt));
    greetingMenu.addItem("변경", new BoardModifyHandler(greetingRepository, prompt));
    greetingMenu.addItem("삭제", new BoardDeleteHandler(greetingRepository, prompt));
    greetingMenu.addItem("목록", new BoardListHandler(greetingRepository, prompt));

//    MenuGroup helpMenu = new MenuGroup("도움말");
//    mainMenu.add(helpMenu);
    mainMenu.addItem("도움말", new HelpHandler(prompt));

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
