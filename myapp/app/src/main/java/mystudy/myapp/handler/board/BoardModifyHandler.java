package mystudy.myapp.handler.board;

import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Board;
import mystudy.util.List;
import mystudy.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardModifyHandler extends AbstractMenuHandler {

  private List<Board> objectRepository;   // 배열값 넣고 빼고

  // BoardRepository에 게시글 배열이 들어있으니 가져온다.
  public BoardModifyHandler(List<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    int index = this.prompt.inputInt("번호? ");
    // 위에 제네릭으로 Board를 지정해주었기 때문에 형변환은 필요가 없다.
    // Board oldboard = (Board) this.objectRepository.get(index);
    Board oldboard = this.objectRepository.get(index);

    Board board = new Board();
    board.setTitle(this.prompt.input("제목(%s)? ", oldboard.getTitle()));
    board.setContent(this.prompt.input("내용(%s)? ", oldboard.getContent()));
    board.setWriter(this.prompt.input("작성자(%s)? ", oldboard.getWriter()));
    board.setCreatedDate(oldboard.getCreatedDate());

    this.objectRepository.set(index, board);
  }
}
