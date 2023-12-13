package mystudy.myapp.handler.board;

import java.util.ArrayList;
import mystudy.menu.Menu;
import mystudy.menu.MenuHandler;
import mystudy.myapp.vo.Board;
import mystudy.util.AnsiEscape;
import mystudy.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardModifywHandler implements MenuHandler {

  ArrayList<Board> objectRepository;   // 배열값 넣고 빼고
  Prompt prompt;                     // 정보 입출력 Scanner

  // BoardRepository에 게시글 배열이 들어있으니 가져온다.
  public BoardModifywHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    this.objectRepository = objectRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    // 위에 제네릭으로 Board를 지정해주었기 때문에 형변환은 필요가 없다.
    // Board oldboard = (Board) this.objectRepository.get(index);
    Board oldboard = this.objectRepository.get(index);
    if (oldboard == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    Board board = new Board();
    board.title = this.prompt.input("제목(%s)? ", oldboard.title);
    board.content = this.prompt.input("내용(%s)? ", oldboard.content);
    board.writer = this.prompt.input("작성자(%s)? ", oldboard.writer);
    board.createdDate = this.prompt.input("작성일(%s)? ", oldboard.createdDate);

    this.objectRepository.set(index, board);
  }
}
