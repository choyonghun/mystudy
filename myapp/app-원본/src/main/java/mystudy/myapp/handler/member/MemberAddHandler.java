package mystudy.myapp.handler.member;

import java.util.Date;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.dao.MemberDao;
import mystudy.myapp.vo.Member;
import mystudy.util.Prompt;

public class MemberAddHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberAddHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    Member member = new Member();
    member.setEmail(this.prompt.input("이메일? "));
    member.setName(this.prompt.input("이름? "));
    member.setPassword(this.prompt.input("암호? "));
    member.setCreatedDate(new Date());

    memberDao.add(member);
  }
}
