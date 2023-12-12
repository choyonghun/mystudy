package mystudy.myapp.handler.member;

import mystudy.menu.Menu;
import mystudy.menu.MenuHandler;
import mystudy.util.AnsiEscape;
import mystudy.util.Prompt;

public class MemberDeleteHandler implements MenuHandler {

  MemberRepository memberRepository;
  Prompt prompt;

  public MemberDeleteHandler(MemberRepository memberRepository, Prompt prompt) {
    this.memberRepository = memberRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    if (this.memberRepository.remove(index) == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
    }
  }
}
