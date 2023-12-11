package mystudy.myapp.menu;

import mystudy.menu.MenuHandler;
import mystudy.myapp.vo.Board;

// 게시글의 '등록' 메뉴를 선택했을때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardListHandler implements MenuHandler {

  BoardRepository boardRepository;

  // BoardRepository에 게시글 배열이 들어있다.
  public BoardListHandler(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @Override
  public void action() {
    System.out.println("게시글 목록");
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    for (int i = 0; i < this.boardRepository.length; i++) {
      Board board = this.boardRepository.boards[i];
      System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
    }
  }
}
