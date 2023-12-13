package mystudy.myapp.handler.board;

import java.util.ArrayList;
import mystudy.menu.Menu;
import mystudy.menu.MenuHandler;
import mystudy.myapp.vo.Board;
import mystudy.util.AnsiEscape;

// 게시글의 '등록' 메뉴를 선택했을때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardListHandler implements MenuHandler {

  ArrayList<Board> objectRepository;

  // BoardRepository에 게시글 배열이 들어있다.
  public BoardListHandler(ArrayList<Board> objectRepository) {
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

//    방법1)
//    Board[] boards = new Board[this.objectRepository.size()];
//    this.objectRepository.toArray(boards);
    //Board[] boards = boardRepository.toArray();  =>  boards 대신에 대입해준다.

//    방법2)
    Board[] boards = this.objectRepository.toArray(new Board[0]);
    // Board board = (Board) object;   //board. 을사용하기 위해 형변환 코드를 적어주었다.
    for (Board board : boards) {
      System.out.printf("%-20s\t%10s\t%s\n",
          board.title,     //object 에 들어있는건 Board 객체이다를 말해준다.
          board.writer,    //object 에 들어있는건 Board 객체이다를 말해준다.
          board.createdDate);
    }
  }
}
