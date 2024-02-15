package mystudy.menu;

import mystudy.util.AnsiEscape;
import mystudy.util.Prompt;

public abstract class AbstractMenuHandler implements MenuHandler {

  protected Prompt prompt;
  protected Menu menu;

  public AbstractMenuHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    this.printMenuTitle(menu.getTitle());
    this.menu = menu;

    // menu를 실행할 때 이 메서드가 호출되면
    // 즉시 서브 클래스의 다음 메서드가 호출된다.
    this.action();
  }

  ;

  public void printMenuTitle(String title) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, title);
  }

  // 서브 클래스가 구현해야할 메서드
  // 슈퍼 클래스의 action(menu)를 실행 할 때 호출되는 메서드이다.
  // 외부에서 호출할 메서드가 아니다.
  // 따라서 접근 범위를 서브클래스에서 접근 할수 있도록 제한한다  public => protected
  protected abstract void action();

}
