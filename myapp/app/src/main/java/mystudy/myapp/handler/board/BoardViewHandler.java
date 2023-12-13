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
public class BoardViewHandler implements MenuHandler {

  ArrayList<Board> objectRepository;   // 배열값 넣고 빼고
  Prompt prompt;                     // 정보 입출력 Scanner

  // BoardRepository에 게시글 배열이 들어있으니 가져온다.
  public BoardViewHandler(ArrayList<Board> objectRepository, Prompt prompt) {
    this.objectRepository = objectRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");

    // Board board = (Board) this.objectRepository.get(index);  //Board 객체안 index에 관한것을 꺼낸다.
    Board board = this.objectRepository.get(index);  // 제레릭<Board>를 해주게 되면 형변환을 안해도된다!!
    if (board == null) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("작성일: %s\n", board.createdDate);
  }
}
