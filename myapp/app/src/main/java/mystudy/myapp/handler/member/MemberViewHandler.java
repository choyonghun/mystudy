package mystudy.myapp.handler.member;

import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.dao.MemberDao;
import mystudy.myapp.vo.Member;
import mystudy.util.Prompt;

public class MemberViewHandler extends AbstractMenuHandler {

  private MemberDao memberDao;

  public MemberViewHandler(MemberDao memberDao, Prompt prompt) {
    super(prompt);
    this.memberDao = memberDao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호? ");
    // objectRepository는 어떤 객체인지 구체적으로 안알려주기 때문에
    // Member 타입을 사용한다고 알려줘야해서 형변환을 해줘야한다
    // (Object)라고 해도 오류는 안나오는데 실행시키면 런타임 에러가 발생한다.
    Member member = memberDao.findBy(no);
    if (member == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("회원번호: %d\n", member.getNo());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("작성일: %tY-%tm-%td %tH:%tM:%tS\n",
        member.getCreatedDate(),
        member.getCreatedDate(),
        member.getCreatedDate(),
        member.getCreatedDate(),
        member.getCreatedDate(),
        member.getCreatedDate());
  }
}
