package mystudy.myapp.handler.board;

import mystudy.menu.Menu;
import mystudy.menu.MenuHandler;
import mystudy.myapp.vo.Board;
import mystudy.util.AnsiEscape;
import mystudy.util.ObjectRepository;
import mystudy.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardAddHandler implements MenuHandler {

  ObjectRepository<Board> objectRepository;

  Prompt prompt;

  // BoardRepository에 게시글 배열이 들어있다.
  public BoardAddHandler(ObjectRepository<Board> objectRepository, Prompt prompt) {
    this.objectRepository = objectRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    Board board = new Board();
    board.title = this.prompt.input("제목? ");
    board.content = this.prompt.input("내용? ");
    board.writer = this.prompt.input("작성자? ");
    board.createdDate = this.prompt.input("작성일? ");

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
