package mystudy.myapp.handler.board;

import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.dao.BoardDao;
import mystudy.myapp.vo.Board;
import mystudy.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardModifyHandler extends AbstractMenuHandler {

  private BoardDao boardDao;   // 배열값 넣고 빼고

  // BoardRepository에 게시글 배열이 들어있으니 가져온다.
  public BoardModifyHandler(BoardDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");

    Board oldboard = this.boardDao.findBy(no);
    if (oldboard == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Board board = new Board();  // 기존 게시글의 번호를 그대로 설정한다.
    board.setTitle(this.prompt.input("제목(%s)? ", oldboard.getTitle()));
    board.setContent(this.prompt.input("내용(%s)? ", oldboard.getContent()));
    board.setWriter(this.prompt.input("작성자(%s)? ", oldboard.getWriter()));
    board.setCreatedDate(oldboard.getCreatedDate());

    boardDao.update(board);
    System.out.println("게시글 변경 했습니다!@");
  }
}
