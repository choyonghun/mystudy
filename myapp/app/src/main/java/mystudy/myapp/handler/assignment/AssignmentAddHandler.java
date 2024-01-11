package mystudy.myapp.handler.assignment;

import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.dao.AssignmentDao;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
public class AssignmentAddHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentdao;

  public AssignmentAddHandler(AssignmentDao assignmentdao, Prompt prompt) {
    super(prompt);
    this.assignmentdao = assignmentdao;
  }

  @Override
  protected void action() {
    try {
      Assignment assignment = new Assignment();
      assignment.setTitle(this.prompt.input("과제명? "));
      assignment.setContent(this.prompt.input("내용? "));
      assignment.setDeadline(this.prompt.inputDate("제출 마감일? (2023-12-25) "));
      assignmentdao.add(assignment);

    } catch (Exception e) {
      System.out.println("과제 입력 중 오류 발생!");
      System.out.println("다시 시도 하시길 바랍니다");
    }
  }
}
