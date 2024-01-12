package mystudy.myapp.handler.member;

import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.dao.MemberDao;
import mystudy.myapp.vo.Member;
import mystudy.util.Prompt;

public class MemberModifyHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberModifyHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    Member oldmember = this.memberDao.findBy(no);
    if (oldmember == null) {
      System.out.println("회원 번호가 유효하지 않습니다");
      return;
    }

    Member member = new Member();
    member.setEmail(this.prompt.input("이메일(%s)? ", oldmember.getEmail()));
    member.setName(this.prompt.input("이름(%s)? ", oldmember.getName()));
    member.setPassword(this.prompt.input("새 암호? "));
    member.setCreatedDate(oldmember.getCreatedDate());

    memberDao.update(member);
    System.out.println("회원 변형 했습니다1@#");
  }
}
