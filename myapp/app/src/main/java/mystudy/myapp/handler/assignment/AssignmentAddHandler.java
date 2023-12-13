package mystudy.myapp.handler.assignment;

import java.util.ArrayList;
import mystudy.menu.Menu;
import mystudy.menu.MenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.AnsiEscape;
import mystudy.util.Prompt;

public class AssignmentAddHandler implements MenuHandler {

  ArrayList<Assignment> objectRepository;
  Prompt prompt;

  public AssignmentAddHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
    this.objectRepository = objectRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    Assignment assignment = new Assignment();
    assignment.title = this.prompt.input("과제명? ");
    assignment.content = this.prompt.input("내용? ");
    assignment.deadline = this.prompt.input("제출 마감일? ");

    objectRepository.add(assignment);
  }
}
