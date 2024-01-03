package mystudy.myapp.handler.assignment;

import java.util.Iterator;
import java.util.List;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

public class AssignmentListHandler extends AbstractMenuHandler {

  private List<Assignment> objectRepository;

  public AssignmentListHandler(List<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    System.out.printf("%-20s\t%s\n", "과제", "제출마감일");

    Iterator<Assignment> iterator = this.objectRepository.iterator();
//    iterator을 사용하면 배열을 사용 안해도된다.
//    Assignment[] assignments = new Assignment[this.objectRepository.size()];
//    this.objectRepository.toArray(assignments);

    while (iterator.hasNext()) {
      Assignment assignment = iterator.next();
      System.out.printf("%-20s\t%s\n", assignment.getTitle(), assignment.getDeadline());
    }
  }
}
