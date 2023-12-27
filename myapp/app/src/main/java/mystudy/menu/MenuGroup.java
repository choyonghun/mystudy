package mystudy.menu;

import mystudy.util.LinkedList;
import mystudy.util.Prompt;

// Composite 패턴에서 '복합 객체 (Composite 객체)' 역할을 할 클래스
// - 다른 Menu 객체를 포함한다.
public class MenuGroup extends AbstractMenu {

  private LinkedList<Menu> menus = new LinkedList<>();

  public MenuGroup(String title) {
    super(title);
  }


  @Override // 인터페이스나 수퍼 클래스의 메서드를 정의 하겠다고 컴파일러한테 알린다.
  public void execute(Prompt prompt) {
    this.printMenu();

    while (true) {
      String input = prompt.input("%s> ", this.getTitle());

      if (input.equals("menu")) {
        this.printMenu();
        continue;
      } else if (input.equals("0")) {
        break;
      }

      try {
        int menuNo = Integer.parseInt(input);
        if (menuNo < 1 || menuNo > this.menus.size()) {
          System.out.println("메뉴 번호가 옳지 않습니다.");
          continue;
        }

        this.menus.get(menuNo - 1).execute(prompt);   //배열은 0번부터 시작하니깐 -1 을 해준다.
      } catch (Exception e) {
        System.out.println("메뉴가 옳지 않습니다.!@!@#");
      }
    }
  }

  private void printMenu() {
    System.out.printf("[%s]\n", this.getTitle());

    for (int i = 0; i < this.menus.size(); i++) {
      System.out.printf("%d. %s\n", (i + 1), menus.get(i).getTitle());
    }
    System.out.printf("0. %s\n", "이전");
  }

  public void add(Menu menu) {
    this.menus.add(menu);
  }

  public void remove(Menu menu) {
    this.menus.remove(menu);
  }

  // 메뉴 객체가 들어있는 배열의 위치를 알아낸다.

}
