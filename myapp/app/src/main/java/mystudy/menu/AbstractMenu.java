package mystudy.menu;

import mystudy.util.Stack;

public abstract class AbstractMenu implements Menu {

  protected Stack<String> breadcrumb;   //자식클래스가 접근할수 있게 protected로
  String title;

  public AbstractMenu(String title, Stack<String> breadcrumb) {
    this.title = title;
    this.breadcrumb = breadcrumb;
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  public String getMenuPath() {
    //String[] paths = breadcrumb.toArray(new String[0]);
    return String.join("/", breadcrumb.toArray(new String[0]));
  }
}
