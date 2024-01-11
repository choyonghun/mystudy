package mystudy.myapp.handler.assignment;

import java.util.List;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.dao.AssignmentDao;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

public class AssignmentDeleteHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentdao;

  private List<Assignment> objectRepository;

  public AssignmentDeleteHandler(AssignmentDao assignmentdao, Prompt prompt) {
    super(prompt);
    this.assignmentdao = assignmentdao;
  }

  @Override
  protected void action() {
    int no = this.prompt.inputInt("번호?");
    if (assignmentdao.delete(no) == 0) {
      System.out.println("과제 번호가 유효하지 않습니다.");
    } else {
      System.out.println("삭제되었습니다.!@#");
    }
  }

}

