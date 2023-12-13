package mystudy.myapp.handler.assignment;

import java.util.ArrayList;
import mystudy.menu.Menu;
import mystudy.menu.MenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.AnsiEscape;

public class AssignmentListHandler implements MenuHandler {

  ArrayList<Assignment> objectRepository;

  public AssignmentListHandler(ArrayList<Assignment> objectRepository) {
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

    Assignment[] assignments = new Assignment[this.objectRepository.size()];
    this.objectRepository.toArray(assignments);

    for (Assignment assignment : assignments) {
      System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
    }
  }
}
