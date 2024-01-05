package mystudy.myapp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

  List<Board> boardRepository;
  List<Assignment> assignmentRepository;
  List<Member> memberRepository;
  List<Board> greetingRepository;

  MenuGroup mainMenu;

  App() {
    loadAssignment();
    loadMember();
    loadBoard();
    loadGreeting();
    prepareMenu();
  }

  public static void main(String[] args) throws Exception {
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
    saveAssignment();
    saveMember();
    saveBoard();
    saveGreeting();
  }

  void loadAssignment() {
    try (FileInputStream in0 = new FileInputStream("assignment.data");
        BufferedInputStream in1 = new BufferedInputStream(in0);
        ObjectInputStream in = new ObjectInputStream(in1)) {

      assignmentRepository = (List<Assignment>) in.readObject();

    } catch (Exception e) {
      assignmentRepository = new LinkedList<>();  //file을 읽을수 없으면 빈 객체를 만들어준다.
      System.out.println("과제 데이터 로딩 중 오류 발생!");
      e.printStackTrace();
    }
  }

  void saveAssignment() {
    try (FileOutputStream out0 = new FileOutputStream("assignment.data");
        BufferedOutputStream out1 = new BufferedOutputStream(out0);
        ObjectOutputStream out = new ObjectOutputStream(out1)) {

      out.writeObject(assignmentRepository);

    } catch (Exception e) {
      System.out.println("과제 데이터 저장 중 오류 발생!");
      e.printStackTrace();
    }
  }

  void loadMember() {
    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream("member.data")))) {

      memberRepository = (List<Member>) in.readObject();

//      int size = in.readShort();
//      for (int i = 0; i < size; i++) {
//        Member member = new Member();
//        member.setName(in.readUTF());
//        member.setEmail(in.readUTF());
//        member.setPassword(in.readUTF());
//        member.setCreatedDate(new java.util.Date(in.readLong()));
//        memberRepository.add(member);
//      }
    } catch (Exception e) {
      memberRepository = new LinkedList<>();
      System.out.println("회원 데이터 로딩 중 오류 발생!");
      e.printStackTrace();
    }
  }

  void saveMember() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream("member.data")))) {

      out.writeObject(memberRepository);

//      out.writeShort(memberRepository.size());
//      for (Member member : memberRepository) {
//        out.writeUTF(member.getName());
//        out.writeUTF(member.getEmail());
//        out.writeUTF(member.getPassword());
//        out.writeLong(member.getCreatedDate().getTime());
//      }

    } catch (Exception e) {
      System.out.println("회원 데이터 저장 중 오류 발생!");
      e.printStackTrace();
    }
  }

  void loadBoard() {
    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream("board.data")))) {

      boardRepository = (List<Board>) in.readObject();

//      int size = in.readShort();
//      for (int i = 0; i < size; i++) {
//        Board board = new Board();
//        board.setTitle(in.readUTF());
//        board.setContent(in.readUTF());
//        board.setWriter(in.readUTF());
//        board.setCreatedDate(new java.util.Date(in.readLong()));
//        boardRepository.add(board);
//      }
    } catch (Exception e) {
      boardRepository = new LinkedList<>();
      System.out.println("게시글 데이터 로딩 중 오류 발생!");
      e.printStackTrace();
    }
  }

  void saveBoard() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream("board.data")))) {

      out.writeObject(boardRepository);

//      out.writeShort(boardRepository.size());
//      for (Board board : boardRepository) {
//        out.writeUTF(board.getTitle());
//        out.writeUTF(board.getContent());
//        out.writeUTF(board.getWriter());
//        out.writeLong(board.getCreatedDate().getTime());
//      }
    } catch (Exception e) {
      System.out.println("게시글 데이터 저장 중 오류 발생!");
      e.printStackTrace();
    }
  }

  void loadGreeting() {
    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream("greeting.data")))) {
      greetingRepository = (List<Board>) in.readObject();

//      int size = in.readShort();
//      for (int i = 0; i < size; i++) {
//        Board board = new Board();
//        board.setTitle(in.readUTF());
//        board.setContent(in.readUTF());
//        board.setWriter(in.readUTF());
//        board.setCreatedDate(new java.util.Date(in.readLong()));
//        greetingRepository.add(board);
//      }
    } catch (Exception e) {
      greetingRepository = new LinkedList<>();
      System.out.println("가입인사 데이터 로딩 중 오류 발생!");
      e.printStackTrace();
    }
  }

  void saveGreeting() {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream("greeting.data")))) {

      out.writeObject(greetingRepository);

//      out.writeShort(greetingRepository.size());
//      for (Board board : greetingRepository) {
//        out.writeUTF(board.getTitle());
//        out.writeUTF(board.getContent());
//        out.writeUTF(board.getWriter());
//        out.writeLong(board.getCreatedDate().getTime());
//      }

    } catch (Exception e) {
      System.out.println("가입인사 데이터 저장 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
