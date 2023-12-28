package mystudy.myapp.handler.board;

import java.util.Date;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Board;
import mystudy.util.List;
import mystudy.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardAddHandler extends AbstractMenuHandler {

  private List<Board> objectRepository;


  // BoardRepository에 게시글 배열이 들어있다.
  public BoardAddHandler(List<Board> objectRepository, Prompt prompt) {
    super(prompt);
    //super을 생략하게 되면 기본생성자가 없어 오류가 뜨게된다.
    this.objectRepository = objectRepository;
  }

  @Override
  public void action() {
    // MenuHandler 인터페이스에 선언된 메서드 대신에
    // AbstractMenuHandler 클래스에 추가된 action() 추상 메서드를 구현한다.
    Board board = new Board();
    board.setTitle(this.prompt.input("제목? "));
    board.setContent(this.prompt.input("내용? "));
    board.setWriter(this.prompt.input("작성자? "));
    board.setCreatedDate(new Date());

    // 목록에 객체를 추가시키는 코드를 BoardRepository가 감췄다. (캡슐화)
    // 대신 목록에 객체를 추가시킬수 있도록 메서드를 제공하고 있다.
    // 따라서 다음과 같이 BoardRepository가 제공하는 메소드를 사용하여 게시글 객체를 추가한다.
    objectRepository.add(board);

    // 레퍼런스 선어하는 시점에 지정된 타입이 아닌 값을 넣으려고 하면
    // 컴파일 오류가 발생한다.
    // 즉 특정 타입만 사용하도록 제한할 수 있는 문법이 제레릭(generic) 이다.
    // objectRepository.add(new String("Hello"));
  }
}
