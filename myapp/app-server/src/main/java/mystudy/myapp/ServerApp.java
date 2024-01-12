package mystudy.myapp;


import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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
    try {
      System.out.println("[과제 관리 서버 시스템]");
      // 1) 네트워크 장비와 연결하기 위한 데이터를 준비한다.
      // 랜카드 연결 정보를 준비한다 => 랜카드와 연결하는 것은 실제 OS가 수행한다.
      // => JVM은 OS가 작업한 결과를 가져온다.
      // new ServerSocket(포트번호)
      // => 외부에서 랜카드로 들어온 데이터를 받을때 사용할 식별번호. 중복불가!
      ServerSocket serverSocket = new ServerSocket(8888);
      System.out.println("서버 실행!");

      // 2) 클라이언트의 연결을 기다림
      // => 클라이언트 대기 목록에서 먼저 연결된 순서대로 클라이언트 연결 정보를 꺼낸다.
      // => 클리이언트 대기 목록에 아무것도 없다면 연결이 될 때 까지 리턴하지 않고 기다린다.
      System.out.println("클라이언트 연결을 기다리는 중...");
      Socket socket = serverSocket.accept();
      System.out.println("대기 목록에서 클라이언트 연결 정보를 꺼냈음!$");

      // 3) 클라이언트와 통신
      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      System.out.println("입출력 준비 완료!#!");

      String dataName = in.readUTF();
      String command = in.readUTF();
      String value = in.readUTF();
      System.out.println("클라이언트가 보낸 데이터 읽음!");

      System.out.println(dataName);
      System.out.println(command);
      System.out.println(value);

      String json = new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
          .toJson(boardDao.findAll());

      out.writeUTF(json);
      System.out.println("클라이언트로 데이터 전송!$%");

    } catch (Exception e) {
      System.out.println("통신 오류!@");
      e.printStackTrace();
    }

  }
}