package mystudy.myapp.handler.member;

import java.util.ArrayList;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Member;
import mystudy.util.Prompt;

public class MemberDeleteHandler extends AbstractMenuHandler {

  private ArrayList<Member> objectRepository;

  public MemberDeleteHandler(ArrayList<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    int index = this.prompt.inputInt("번호? ");
    this.objectRepository.remove(index);
  }
}
