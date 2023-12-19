package mystudy.myapp.handler;

import mystudy.menu.AbstractMenuHandler;
import mystudy.util.Prompt;

public class HelpHandler extends AbstractMenuHandler {

  public HelpHandler(Prompt prompt) {
    super(prompt);
  }

  protected void action() {
    System.out.println("도움말입니다.");
  }

}
