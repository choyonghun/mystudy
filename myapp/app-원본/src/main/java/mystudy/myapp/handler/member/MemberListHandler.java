package mystudy.myapp.handler.member;

import java.util.List;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.dao.MemberDao;
import mystudy.myapp.vo.Member;
import mystudy.util.Prompt;

public class MemberListHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberListHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t-10s\t%30s\t%s\n", "No", "이름", "이메일", "가입일");

    // iterator을 사용하면 배열은 필요가 없다!
    List<Member> list = memberDao.findAll();
    for (Member member : list) {
      System.out.printf("%-4s\t%-10s\t%30s\t%s\n",
          member.getNo(),
          member.getName(),
          member.getEmail(),
          member.getCreatedDate());
    }

//    Member[] members = new Member[this.objectRepository.size()];
//    this.objectRepository.toArray(members);
//    for (Member member : members) {
//      System.out.printf("%-10s\t%30s\t%s\n", member.getName(), member.getEmail(),
//          member.getCreatedDate());
//    }
  }
}
