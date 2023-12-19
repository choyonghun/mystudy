package mystudy.menu;

import mystudy.util.Prompt;

// Composite 패턴에서 '복합 객체 (Composite 객체)' 역할을 할 클래스
// - 다른 Menu 객체를 포함한다.
public class MenuGroup extends AbstractMenu {

  private Menu[] menus = new Menu[10];
  private int menuSize;

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

      int menuNo = Integer.parseInt(input);
      if (menuNo < 1 || menuNo > menuSize) {
        System.out.println("메뉴 번호가 옳지 않습니다.");
        continue;
      }

      this.menus[menuNo - 1].execute(prompt);   //배열은 0번부터 시작하니깐 -1 을 해준다.
    }
  }

  private void printMenu() {
    System.out.printf("[%s]\n", this.getTitle());

    for (int i = 0; i < this.menuSize; i++) {
      System.out.printf("%d. %s\n", (i + 1), menus[i].getTitle());
    }
    System.out.printf("0. %s\n", "이전");
  }

  public void add(Menu menu) {
    if (this.menuSize == this.menus.length) { //꽉찾을경우
      int oldSize = this.menus.length;
      int newSize = oldSize + (oldSize >> 1);

      Menu[] arr = new Menu[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.menus[i];
      }
      this.menus = arr;   //기본배열이 새배열을 뜻한다
    }
    this.menus[this.menuSize++] = menu;
  }

  public void remove(Menu menu) {
    int index = this.indexOf(menu);
    if (index == -1) {
      return;
    }

    for (int i = index; i < (this.menuSize - 1); i++) {
      this.menus[i] = this.menus[i + 1];
    }
    this.menus[--this.menuSize] = null;
  }

  // 메뉴 객체가 들어있는 배열의 위치를 알아낸다.
  int indexOf(Menu menu) {
    int index = -1;
    for (int i = 0; i < menuSize; i++) {
      if (menu == this.menus[i]) {
        index = i;
      }
    }
    return -1;
  }
}
