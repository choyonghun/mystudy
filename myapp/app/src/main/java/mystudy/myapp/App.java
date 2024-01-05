package mystudy.myapp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mystudy.menu.MenuGroup;
import mystudy.myapp.handler.HelpHandler;
import mystudy.myapp.handler.assignment.AssignmentAddHandler;
import mystudy.myapp.handler.assignment.AssignmentDeleteHandler;
import mystudy.myapp.handler.assignment.AssignmentListHandler;
import mystudy.myapp.handler.assignment.AssignmentModifyHandler;
import mystudy.myapp.handler.assignment.AssignmentViewHandler;
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

  List<Board> boardRepository = new ArrayList<>();
  List<Assignment> assignmentRepository = new LinkedList<>();
  List<Member> memberRepository = new ArrayList<>();
  List<Board> greetingRepository = new LinkedList<>();

  MenuGroup mainMenu;

  App() {
    assignmentRepository = loadData("assignment.data");
    memberRepository = loadData("member.data");
    boardRepository = loadData("board.data");
    greetingRepository = loadData("greeting.data");
    prepareMenu();
  }

  public static void main(String[] args) {
    new App().run();
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup assignmentMenu = mainMenu.addGroup("과제");
    assignmentMenu.addItem("등록", new AssignmentAddHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("조회", new AssignmentViewHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("변경", new AssignmentModifyHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(assignmentRepository, prompt));
    assignmentMenu.addItem("목록", new AssignmentListHandler(assignmentRepository, prompt));

    MenuGroup boardMenu = mainMenu.addGroup("게시글");
    boardMenu.addItem("등록", new BoardAddHandler(boardRepository, prompt));
    boardMenu.addItem("조회", new BoardViewHandler(boardRepository, prompt));
    boardMenu.addItem("변경", new BoardModifyHandler(boardRepository, prompt));
    boardMenu.addItem("삭제", new BoardDeleteHandler(boardRepository, prompt));
    boardMenu.addItem("목록", new BoardListHandler(boardRepository, prompt));

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(memberRepository, prompt));
    memberMenu.addItem("조회", new MemberViewHandler(memberRepository, prompt));
    memberMenu.addItem("변경", new MemberModifyHandler(memberRepository, prompt));
    memberMenu.addItem("삭제", new MemberDeleteHandler(memberRepository, prompt));
    memberMenu.addItem("목록", new MemberListHandler(memberRepository, prompt));

    MenuGroup greetingMenu = mainMenu.addGroup("가입인사");
    greetingMenu.addItem("등록", new BoardAddHandler(greetingRepository, prompt));
    greetingMenu.addItem("조회", new BoardViewHandler(greetingRepository, prompt));
    greetingMenu.addItem("변경", new BoardModifyHandler(greetingRepository, prompt));
    greetingMenu.addItem("삭제", new BoardDeleteHandler(greetingRepository, prompt));
    greetingMenu.addItem("목록", new BoardListHandler(greetingRepository, prompt));

    mainMenu.addItem("도움말", new HelpHandler(prompt));
  }

  void run() {
    while (true) {
      try {
        mainMenu.execute(prompt);
        prompt.close();
        break;
      } catch (Exception e) {
        System.out.println("예외 발생!");
      }
    }
    saveData("assignment.csv", assignmentRepository);
    saveData("member.csv", memberRepository);
    saveData("board.csv", boardRepository);
    saveData("greeting.csv", greetingRepository);
  }

  <E> List<E> loadData(String filepath) {
    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream(filepath)))) {

      return (List<E>) in.readObject();

    } catch (Exception e) {
      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filepath);
      e.printStackTrace();
    }
    return new ArrayList<E>();
  }

  void saveData(String filepath, List<?> dataList) {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream(filepath)))) {

      out.writeObject(dataList);

    } catch (Exception e) {
      System.out.printf("%s 파일 저장 중 오류 발생!\n", filepath);
      e.printStackTrace();
    }
  }

//  void saveData(String filepath, List<? extends CsvString> dataList) {
//    try (FileWriter out = new FileWriter(filepath)) {
//
//      for (CsvString csvObject : dataList) {
//        out.write(csvObject.toCsvString() + "\n");
//      }
//
//    } catch (Exception e) {
//      System.out.printf("%s 파일 저장 중 오류 발생!\n", filepath);
//      e.printStackTrace();
//    }
//  }
}