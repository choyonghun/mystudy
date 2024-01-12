package mystudy.myapp.handler.assignment;

import java.util.List;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.dao.AssignmentDao;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

public class AssignmentListHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentdao;

  public AssignmentListHandler(AssignmentDao assignmentdao, Prompt prompt) {
    super(prompt);
    this.assignmentdao = assignmentdao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-20s\t%s\n", "No", "과제", "제출마감일");

    List<Assignment> list = assignmentdao.findAll();
//    iterator을 사용하면 배열을 사용 안해도된다.
//    Assignment[] assignments = new Assignment[this.objectRepository.size()];
//    this.objectRepository.toArray(assignments);

    for (Assignment assignment : list) {
      System.out.printf("%-4d\t%-20s\t%s\n", assignment.getNo(), assignment.getTitle(),
          assignment.getDeadline());
    }
  }
}
