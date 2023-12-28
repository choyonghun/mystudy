package mystudy.myapp.handler.member;

import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Member;
import mystudy.util.List;
import mystudy.util.Prompt;

public class MemberViewHandler extends AbstractMenuHandler {

  private List<Member> objectRepository;

  public MemberViewHandler(List<Member> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    int index = this.prompt.inputInt("번호? ");
    // objectRepository는 어떤 객체인지 구체적으로 안알려주기 때문에
    // Member 타입을 사용한다고 알려줘야해서 형변환을 해줘야한다
    // (Object)라고 해도 오류는 안나오는데 실행시키면 런타임 에러가 발생한다.
    Member member = this.objectRepository.get(index);

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
