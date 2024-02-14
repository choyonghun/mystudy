package bitcamp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {

  // 개별 스레드용 DB 커넥션 저장소
  private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
  
  // DB 커넥션 목록
  ArrayList<Connection> connections = new ArrayList<>();
  private String jdbcUrl;
  private String username;
  private String password;

  public DBConnectionPool(String jbcUrl, String username, String password) {
    this.jdbcUrl = jbcUrl;
    this.password = password;
    this.username = username;
  }

  public Connection getConnection() throws Exception {
    // 현재 스레드에 보관중인 Connection 객체를 꺼낸다.
    Connection con = connectionThreadLocal.get();

    if (con == null) {
      // 스레드에 보관된 Connection 이 없다면,

      if (connections.size() > 0) {
        // 스레드풀에 놀고있는 connection이 있다면
        // 목록에서 맨 처음 객체를 꺼낸다.
        con = connections.remove(0);
        System.out.printf("%s: DB 커넥션풀에서 꺼냄\n", Thread.currentThread().getName());

      } else {
        // 스레드풀에도 놀고있는 Connection이 없다면,
        // 새로 Connection을 만든다.
        con = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.printf("%s: DB 커넥션 생성\n", Thread.currentThread().getName());
      }
      // 나중에 또 사용할수 있도록 현재 스레드에 보관한다.
      connectionThreadLocal.set(con);

    } else {
      System.out.printf("%s: 스레드에 보관된 DB 커넥션 리턴\n", Thread.currentThread().getName());
    }
    return con;
  }

  public void returnConnection(Connection con) {
    // 현재 스레드에 보관중인 Connection 객체를 제거한다.
    connectionThreadLocal.remove();

    // Connection을 커넥션 풀에 반환한다.

    if (con != null) {
      try {
        con.close();
      } catch (Exception e) {
      }
      connectionThreadLocal.remove();
      System.out.printf("%s: DB 커넥션 제거\n", Thread.currentThread().getName());
    }
  }
}
