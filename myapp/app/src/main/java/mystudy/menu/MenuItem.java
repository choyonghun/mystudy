package mystudy.menu;

import mystudy.util.Prompt;

// Composite 패턴에서 leaf역할을 수행하는 클래스
// Leaf 란  =>  하위 항목을 포함하지 않는 말단 객체
// 예를 들어 파일시스템에서 '파일'에 해당한다
public class MenuItem implements Menu {

  String title;
  MenuHandler menuHandler;

  // 제목만 설정
  public MenuItem(String title) {
    this.title = title;
  }

  // 제목 + handler 같이 설정
  public MenuItem(String title, MenuHandler menuHandler) {
    this(title);
    this.menuHandler = menuHandler;
  }

  public void execute(Prompt prompt) {
    if (this.menuHandler != null) {
      this.menuHandler.action();
    }
  }

  @Override
  public String getTitle() {
    return this.title;
  }

}
