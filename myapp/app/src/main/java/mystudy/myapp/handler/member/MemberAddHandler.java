package mystudy.myapp.handler.member;

import java.util.ArrayList;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Member;
import mystudy.util.Prompt;

public class MemberAddHandler extends AbstractMenuHandler {

  private ArrayList<Member> objectRepository;

  public MemberAddHandler(ArrayList<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    Member member = new Member();
    member.setEmail(this.prompt.input("이메일? "));
    member.setName(this.prompt.input("이름? "));
    member.setPassword(this.prompt.input("암호? "));
    member.setCreatedDate(this.prompt.input("가입일? "));

    objectRepository.add(member);
  }
}
