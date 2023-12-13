package mystudy.myapp.handler.assignment;

import java.util.ArrayList;
import mystudy.menu.Menu;
import mystudy.menu.MenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.AnsiEscape;
import mystudy.util.Prompt;

public class AssignmentDeleteHandler implements MenuHandler {

  ArrayList<Assignment> objectRepository;
  Prompt prompt;

  public AssignmentDeleteHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
    this.objectRepository = objectRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    if (this.objectRepository.remove(index) == null) {
      System.out.println("과제 번호가 유효하지 않습니다.");
    }
  }
}

