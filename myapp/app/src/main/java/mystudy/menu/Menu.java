package mystudy.menu;

import mystudy.util.Prompt;

//메뉴를 처리하는 객체의 사용법을 정의한다.
public interface Menu {

  // 객체를 실행할 때 호출할 메서드를 선언한다.
  // 구현을 해서는 안된다.
  // abstract => 추상메서드

  // 인터페이스나 수퍼 클래스의 메서드를 정의 하겠다고 컴파일러한테 알린다.
  public abstract void execute(Prompt prompt);

  public abstract String getTitle();
}
