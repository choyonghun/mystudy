package mystudy.myapp.handler.member;

import mystudy.menu.Menu;
import mystudy.menu.MenuHandler;
import mystudy.myapp.vo.Member;
import mystudy.util.AnsiEscape;
import mystudy.util.Prompt;

public class MemberViewHandler implements MenuHandler {

  MemberRepository memberRepository;
  Prompt prompt;

  public MemberViewHandler(MemberRepository memberRepository, Prompt prompt) {
    this.memberRepository = memberRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    Member member = this.memberRepository.get(index);
    if (member == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }
    System.out.printf("이메일: %s\n", member.email);
    System.out.printf("이름: %s\n", member.name);
    System.out.printf("가입일: %s\n", member.createdDate);
  }
}
