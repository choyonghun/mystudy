package mystudy.myapp.handler.member;

import java.util.Iterator;
import java.util.List;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Member;
import mystudy.util.Prompt;

public class MemberListHandler extends AbstractMenuHandler {

  private List<Member> objectRepository;

  public MemberListHandler(List<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    System.out.printf("%-10s\t%30s\t%s\n", "이름", "이메일", "가입일");

    // iterator을 사용하면 배열은 필요가 없다!
    Iterator<Member> iterator = this.objectRepository.iterator();
    while (iterator.hasNext()) {
      Member member = iterator.next();
      System.out.printf("%-10s\t%30s\t%s\n", member.getName(), member.getEmail(),
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
