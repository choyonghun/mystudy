package mystudy.menu;

import mystudy.util.Prompt;
import mystudy.util.Stack;

// Composite 패턴에서 leaf역할을 수행하는 클래스
// Leaf 란  =>  하위 항목을 포함하지 않는 말단 객체
// 예를 들어 파일시스템에서 '파일'에 해당한다
public class MenuItem extends AbstractMenu {

  private MenuHandler menuHandler;

  // 제목만 설정
  public MenuItem(String title, Stack<String> breadcrumb) {
    super(title, breadcrumb);
  }

  // 제목 + handler 같이 설정
  public MenuItem(String title, Stack<String> breadcrumb, MenuHandler menuHandler) {
    this(title, breadcrumb);
    this.menuHandler = menuHandler;
  }

  public void execute(Prompt prompt) {
    if (this.menuHandler != null) {
      try {
        this.menuHandler.action(this);
      } catch (Exception e) {
        System.out.println("실행 오류~!@#$");
      }
    }
  }
}
