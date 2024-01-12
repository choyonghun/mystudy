package mystudy.myapp;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import mystudy.myapp.dao.AssignmentDao;
import mystudy.myapp.dao.BoardDao;
import mystudy.myapp.dao.MemberDao;
import mystudy.myapp.dao.json.AssignmentDaoImpl;
import mystudy.myapp.dao.json.BoardDaoImpl;
import mystudy.myapp.dao.json.MemberDaoImpl;
import mystudy.myapp.vo.Board;
import mystudy.util.Prompt;

public class ClientApp {

  Prompt prompt = new Prompt(System.in);

  BoardDao boardDao = new BoardDaoImpl("board.json");
  BoardDao greetingDao = new BoardDaoImpl("greeting.json");
  AssignmentDao assignmentDao = new AssignmentDaoImpl("assignment.json");
  MemberDao memberDao = new MemberDaoImpl("member.json");


  public static void main(String[] args) {
    System.out.println("[과제관리 시스템]");

    try {
      // 1) 서버와 연결한 후 연결 정보 준비
      // => new Socket(서버주소, 포트번호)
      //   - 서버 주소 : IP주소, 도메인명
      //   - 포트 번호 : 상대편 포트 번호
      // => 로컬 컴퓨터를 가리키는 주소    IP주소 : 127.0.0.1   도메인명 : (localhost)
      System.out.println("서버 연결 중 ...");
      Socket socket = new Socket("localhost", 8888);
      System.out.println("서버와 연결되었음!!!");

      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      System.out.println("입출력 준비 완료!&#$");

      out.writeUTF("board");
      out.writeUTF("findAll");
      out.writeUTF("");
      System.out.println("서버에 데이터를 보냈음!&$");

      String response = in.readUTF();
      ArrayList<Board> list = (ArrayList<Board>) new GsonBuilder().setDateFormat("yyyy-MM-dd")
          .create().fromJson(response,
              TypeToken.getParameterized(ArrayList.class, Board.class));

      System.out.println(response);

      for (Board board : list) {
        System.out.println(board);
      }

    } catch (Exception e) {
      System.out.println("통신 오류$#@");
      e.printStackTrace();
    }
  }
}