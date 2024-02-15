package mystudy.myapp.handler.board;

import java.util.List;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.dao.BoardDao;
import mystudy.myapp.vo.Board;
import mystudy.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardListHandler extends AbstractMenuHandler {

  private BoardDao boardDao;

  // BoardRepository에 게시글 배열이 들어있다.
  public BoardListHandler(BoardDao boardDao, Prompt prompt) {
    super(prompt);
    this.boardDao = boardDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%10s\t%s\n", "No", "Title", "Writer", "Date");

//    방법1)
//    Board[] boards = new Board[this.objectRepository.size()];
//    this.objectRepository.toArray(boards);
    //Board[] boards = boardRepository.toArray();  =>  boards 대신에 대입해준다.

//    방법2)
//    Board[] boards = this.objectRepository.toArray(new Board[0]);
    // Board board = (Board) object;   //board. 을사용하기 위해 형변환 코드를 적어주었다.

//    방법3) iterator 사용하면 배열이 필요가 없다.
    List<Board> list = boardDao.findAll();

    for (Board board : list) {
      System.out.printf("%-4d\t%-20s\t%10s\t%4$tY-%4$tm-%4$td\n",
          board.getNo(),
          board.getTitle(),     //object 에 들어있는건 Board 객체이다를 말해준다.
          board.getWriter(),    //object 에 들어있는건 Board 객체이다를 말해준다.
          board.getCreatedDate());
    }
  }
}