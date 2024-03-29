package mystudy.myapp.handler.board;

import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.dao.BoardDao;
import mystudy.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardDeleteHandler extends AbstractMenuHandler {

  private BoardDao boardDao;   // 배열값 넣고 빼고

  // BoardRepository에 게시글 배열이 들어있으니 가져온다.
  public BoardDeleteHandler(BoardDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  protected void action() {
    int index = this.prompt.inputInt("번호? ");
    if (boardDao.delete(index) == 0) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제했습니다.");
    }
  }
}