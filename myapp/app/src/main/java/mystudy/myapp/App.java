package mystudy.myapp;

import mystudy.menu.MenuGroup;
import mystudy.menu.MenuHandler;
import mystudy.menu.MenuItem;
import mystudy.myapp.handler.assignment.AssignmentAddHandler;
import mystudy.myapp.handler.assignment.AssignmentDeleteHandler;
import mystudy.myapp.handler.assignment.AssignmentListHandler;
import mystudy.myapp.handler.assignment.AssignmentModifyHandler;
import mystudy.myapp.handler.assignment.AssignmentRepository;
import mystudy.myapp.handler.assignment.assignmentViewHandler;
import mystudy.myapp.handler.board.BoardAddHandler;
import mystudy.myapp.handler.board.BoardDeleteHandler;
import mystudy.myapp.handler.board.BoardListHandler;
import mystudy.myapp.handler.board.BoardModifywHandler;
import mystudy.myapp.handler.board.BoardViewHandler;
import mystudy.myapp.handler.member.MemberAddHandler;
import mystudy.myapp.handler.member.MemberDeleteHandler;
import mystudy.myapp.handler.member.MemberListHandler;
import mystudy.myapp.handler.member.MemberModifyHandler;
import mystudy.myapp.handler.member.MemberRepository;
import mystudy.myapp.handler.member.MemberViewHandler;
import mystudy.util.ObjectRepository;
import mystudy.util.Prompt;

public class App {

  public static void main(String[] args) throws Exception {
    Prompt prompt = new Prompt(System.in);
    //new MainMenu(prompt).execute();

    ObjectRepository objectRepository = new ObjectRepository();
    AssignmentRepository assignmentRepository = new AssignmentRepository();
    MemberRepository memberRepository = new MemberRepository();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem("등록", new AssignmentAddHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("조회", new assignmentViewHandler(assignmentRepository, prompt)));
    assignmentMenu.add(
        new MenuItem("변경", new AssignmentModifyHandler(assignmentRepository, prompt)));
    assignmentMenu.add(
        new MenuItem("삭제", new AssignmentDeleteHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("목록", new AssignmentListHandler(assignmentRepository)));
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
    boardMenu.add(new MenuItem("변경", new BoardModifywHandler(objectRepository, prompt)));
//    BoardModifywHandler handler = new BoardModifywHandler(boardRepository, prompt);
//    MenuItem menuItem = new MenuItem("변경", handler);
//    boardMenu.add(menuItem);
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler(objectRepository, prompt)));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(objectRepository)));
    mainMenu.add(boardMenu);

    //============================================================================
    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem("등록", new MemberAddHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("조회", new MemberViewHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("변경", new MemberModifyHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("삭제", new MemberDeleteHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("목록", new MemberListHandler(memberRepository)));
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

    mainMenu.execute(prompt);

    prompt.close();
  }
}
