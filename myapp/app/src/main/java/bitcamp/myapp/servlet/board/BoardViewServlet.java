package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardViewServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.boardDao = new BoardDaoImpl(connectionPool, 1);
    this.attachedFileDao = new AttachedFileDaoImpl(connectionPool);
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Board board = boardDao.findBy(no);
      if (board == null) {
        out.println("게시글 번호가 유효하지 않습니다.");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);

      out.println("<form action='/board/update'>");
      out.println("<div>");
      out.printf("번호: <input readonly name='no' type='text' value ='%s'>\n ", board.getNo());
      out.println("</div>");
      out.println("<div>");
      out.printf("제목: <input name='title' type='text' value ='%s'>\n ", board.getTitle());
      out.println("</div>");
      out.println("<div>");
      out.printf(" 내용: <textarea name='content'>%s</textarea>\n", board.getContent());
      out.println("</div>");
      out.println("<div>");
      out.println("첨부파일: <input multiple name='files' type='file'>");
      out.println("</div>");
      out.println("<div>");
      out.println(" <button>등록</button>");
      out.println(" </div>");
      out.println("</form>");

      prompt.printf("번호: %d\n", board.getNo());
      prompt.printf("제목: %s\n", board.getTitle());
      prompt.printf("내용: %s\n", board.getContent());
      prompt.printf("작성자: %s\n", board.getWriter().getName());
      prompt.printf("작성일: %1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", board.getCreatedDate());
      prompt.println("첨부파일:");

      for (AttachedFile file : files) {
        prompt.printf("  %s\n", file.getFilePath());
      }

    } catch (Exception e) {
      prompt.println("조회 오류!");
    }
  }
}
/*
[조회]
번호? 7
번호: 7
제목: a2
내용: aa2
작성자: a
작성일: 2024-02-14 00:00:00
첨부파일:
  a1.gif
  a2.gif
  a3.gif
 */