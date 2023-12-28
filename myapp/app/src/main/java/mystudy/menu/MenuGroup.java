package mystudy.menu;

import mystudy.util.LinkedList;
import mystudy.util.List;
import mystudy.util.Prompt;
import mystudy.util.Stack;

// Composite 패턴에서 '복합 객체 (Composite 객체)' 역할을 할 클래스
// - 다른 Menu 객체를 포함한다.
public class MenuGroup extends AbstractMenu {

  private List<Menu> menus = new LinkedList<>();


  private MenuGroup(String title, Stack<String> breadcrumb) {
    super(title, breadcrumb);
  }

  public static MenuGroup getInstance() {

  }


  @Override // 인터페이스나 수퍼 클래스의 메서드를 정의 하겠다고 컴파일러한테 알린다.
  public void execute(Prompt prompt) {
    // 메뉴를 실행할 때 메뉴의 제복을 breadcrumb 경로에 추가한다.
    breadcrumb.push(this.title);

    this.printMenu();

    while (true) {
      String input = prompt.input("%s> ", this.getMenuPath());

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
    // 메뉴를 나갈때 breadcrumb 메뉴 경로에서 메뉴 제목을 제거한다.
    breadcrumb.pop();
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

  public MenuItem addItem(String title, MenuHandler handler) {
    MenuItem menuItem = new MenuItem(title, this.breadcrumb, handler);
    this.add(menuItem);
    return menuItem;
  }

  public MenuGroup addGroup(String title) {
    MenuGroup menuGroup = new MenuGroup(title, this.breadcrumb);
    this.add(menuGroup);
    return menuGroup;
  }

  public void remove(Menu menu) {
    this.menus.remove(menu);
  }

  // 메뉴 객체가 들어있는 배열의 위치를 알아낸다.

}
