package mystudy.myapp.handler.member;

import java.util.ArrayList;
import mystudy.menu.Menu;
import mystudy.menu.MenuHandler;
import mystudy.myapp.vo.Member;
import mystudy.util.AnsiEscape;
import mystudy.util.Prompt;

public class MemberViewHandler implements MenuHandler {

  ArrayList<Member> objectRepository;
  Prompt prompt;

  public MemberViewHandler(ArrayList<Member> objectRepository, Prompt prompt) {
    this.objectRepository = objectRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    // objectRepository는 어떤 객체인지 구체적으로 안알려주기 때문에
    // Member 타입을 사용한다고 알려줘야해서 형변환을 해줘야한다
    // (Object)라고 해도 오류는 안나오는데 실행시키면 런타임 에러가 발생한다.
    Member member = this.objectRepository.get(index);
    if (member == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("가입일: %s\n", member.createdDate);
  }
}
