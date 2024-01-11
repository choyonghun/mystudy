package mystudy.myapp.handler.assignment;

import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.dao.AssignmentDao;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

public class AssignmentViewHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentdao;

  public AssignmentViewHandler(AssignmentDao assignmentdao, Prompt prompt) {
    super(prompt);
    this.assignmentdao = assignmentdao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");

      Assignment assignment = assignmentdao.findBy(no);
      if (assignment == null) {
        System.out.println("과제 번호가 유효하지 않습니다.");
        return;
      }

      System.out.printf("번호: %d\n", assignment.getNo());
      System.out.printf("과제명: %s\n", assignment.getTitle());
      System.out.printf("내용: %s\n", assignment.getContent());
      System.out.printf("제출 마감일: %s\n", assignment.getDeadline());

    } catch (Exception e) {
      System.out.println("조회 오류!");
    }
  }
}
