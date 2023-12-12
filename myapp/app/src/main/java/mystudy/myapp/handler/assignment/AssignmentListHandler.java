package mystudy.myapp.handler.assignment;

import mystudy.menu.Menu;
import mystudy.menu.MenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.AnsiEscape;

public class AssignmentListHandler implements MenuHandler {

  AssignmentRepository assignmentRepository;

  public AssignmentListHandler(AssignmentRepository assignmentRepository) {
    this.assignmentRepository = assignmentRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

    for (Assignment assignment : assignmentRepository.toArray()) {
      System.out.printf("%-20s\t%s\n", assignment.title, assignment.deadline);
    }
  }
}
