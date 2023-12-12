package mystudy.myapp.handler.member;

import mystudy.menu.Menu;
import mystudy.menu.MenuHandler;
import mystudy.myapp.vo.Member;
import mystudy.util.AnsiEscape;
import mystudy.util.Prompt;

public class MemberModifyHandler implements MenuHandler {

  MemberRepository memberRepository;
  Prompt prompt;

  public MemberModifyHandler(MemberRepository memberRepository, Prompt prompt) {
    this.memberRepository = memberRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    Member old = this.memberRepository.get(index);
    if (old == null) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    Member member = new Member();
    member.email = this.prompt.input("이메일(%s)? ", old.email);
    member.name = this.prompt.input("이름(%s)? ", old.name);
    member.password = this.prompt.input("새 암호? ");
    member.createdDate = this.prompt.input("가입일(%s)? ", old.createdDate);

    this.memberRepository.set(index, member);
  }
}
