package mystudy.myapp.handler.assignment;

import java.util.ArrayList;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

public class AssignmentListHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;

  public AssignmentListHandler(ArrayList<Assignment> objectRepositorym, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

    Assignment[] assignments = new Assignment[this.objectRepository.size()];
    this.objectRepository.toArray(assignments);

    for (Assignment assignment : assignments) {
      System.out.printf("%-20s\t%s\n", assignment.getTitle(), assignment.getDeadline());
    }
  }
}
