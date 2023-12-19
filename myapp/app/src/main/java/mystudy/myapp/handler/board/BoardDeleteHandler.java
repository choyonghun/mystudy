package mystudy.myapp.handler.board;

import java.util.ArrayList;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Board;
import mystudy.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardDeleteHandler extends AbstractMenuHandler {

  private ArrayList<Board> objectRepository;   // 배열값 넣고 빼고

  // BoardRepository에 게시글 배열이 들어있으니 가져온다.
  public BoardDeleteHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    int index = this.prompt.inputInt("번호? ");
    if (this.objectRepository.remove(index) == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
    }
  }
}