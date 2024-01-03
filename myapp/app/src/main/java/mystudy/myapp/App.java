package mystudy.myapp;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
import mystudy.util.Prompt;

public class App {

  Prompt prompt = new Prompt(System.in);

  List<Board> objectRepository = new LinkedList<>();
  List<Assignment> assignmentRepository = new LinkedList<>();
  List<Member> memberRepository = new ArrayList<>();
  List<Board> greetingRepository = new LinkedList<>();

  MenuGroup mainMenu;

  App() {
    prepareMenu();
  }

  public static void main(String[] args) throws Exception {
    new App().run();
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

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
  }

  void run() {
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생@!!@!@!");
      }
    }
    saveAssignment();
  }

  void loadAssignment() {

  }

  void saveAssignment() {
    // 안에다 넣으면 자동으로 close() 가 실행된다.
    try (FileOutputStream out = new FileOutputStream("assignment.data");) {
      for (Assignment assignment : assignmentRepository) {
        // assignment 객체에서 값을 꺼내 바이트 배열로 만든 다음에 출력한다.
        String title = assignment.getTitle();
        byte[] bytes = title.getBytes("UTF-8");
        out.write();
      }

      out.close();
    } catch (Exception e) {
      System.out.println("과제 데이터 저장 중 오류 발생!!@!");
    }
  }
}
