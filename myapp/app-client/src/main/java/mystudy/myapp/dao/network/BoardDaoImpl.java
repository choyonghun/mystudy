package mystudy.myapp.dao.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import mystudy.myapp.dao.BoardDao;
import mystudy.myapp.dao.DaoException;
import mystudy.myapp.vo.Board;

public class BoardDaoImpl implements BoardDao {
  // BoardDao의 키워드르 사용하면 해당 인터페이스의 메서드를 구현하겠다.

  String dataName;
  DataInputStream in;
  DataOutputStream out;
  Gson gson;

  public BoardDaoImpl(String dataName, DataInputStream in, DataOutputStream out) {
    this.dataName = dataName;
    this.in = in;
    this.out = out;
    gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
  }

  @Override
  public void add(Board board) {
    try {
      out.writeUTF("board");
      out.writeUTF("add");
      out.writeUTF(gson.toJson(board));

      String statusCode = in.readUTF();
      String entity = in.readUTF();

      if (statusCode.equals("200")) {
        throw new Exception(entity);
      }
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      out.writeUTF("board");
      out.writeUTF("delete");
      out.writeUTF(gson.toJson(no));

      String statusCode = in.readUTF();
      String entity = in.readUTF();

      if (statusCode.equals("200")) {
        throw new Exception(entity);
      }
      return gson.fromJson(entity, int.class);    //int값으로 바꾼다 라는 뜻

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public List<Board> findAll() {
    try {
      out.writeUTF("board");
      out.writeUTF("findAll");
      out.writeUTF("");

      String statusCode = in.readUTF();
      String entity = in.readUTF();

      if (statusCode.equals("200")) {
        throw new Exception(entity);
      }
      return (List<Board>) gson.fromJson(entity,
          TypeToken.getParameterized(ArrayList.class, Board.class));
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public Board findBy(int no) {
    try {
      out.writeUTF("board");
      out.writeUTF("findBy");
      out.writeUTF(gson.toJson(no));

      String statusCode = in.readUTF();
      String entity = in.readUTF();

      if (statusCode.equals("200")) {
        throw new Exception(entity);
      }

      return gson.fromJson(entity, Board.class);

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int update(Board board) {
    try {
      out.writeUTF("board");
      out.writeUTF("update");
      out.writeUTF(gson.toJson(board));

      String statusCode = in.readUTF();
      String entity = in.readUTF();

      if (statusCode.equals("200")) {
        throw new Exception(entity);
      }

      return gson.fromJson(entity, int.class);

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }
}
