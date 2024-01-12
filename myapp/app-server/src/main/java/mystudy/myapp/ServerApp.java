package mystudy.myapp;


import mystudy.myapp.dao.AssignmentDao;
import mystudy.myapp.dao.BoardDao;
import mystudy.myapp.dao.MemberDao;
import mystudy.myapp.dao.json.AssignmentDaoImpl;
import mystudy.myapp.dao.json.BoardDaoImpl;
import mystudy.myapp.dao.json.MemberDaoImpl;

public class ServerApp {

  BoardDao boardDao = new BoardDaoImpl("board.json");
  BoardDao greetingDao = new BoardDaoImpl("greeting.json");
  AssignmentDao assignmentDao = new AssignmentDaoImpl("assignment.json");
  MemberDao memberDao = new MemberDaoImpl("member.json");


  public static void main(String[] args) {
    new ServerApp().run();
  }


  void run() {
    System.out.println("[과제 관리 서버 시스템]");
    // 1) 네트워크 장비와 연결된 정보를 준비한다.
    
    // 2) 클라이언트의 연결을 기다림
    // 3) 클라이언트와 통신
    // 4)

  }
}