package mystudy.myapp.handler.assignment;

import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.dao.AssignmentDao;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

public class AssignmentModifyHandler extends AbstractMenuHandler {

  private AssignmentDao assignmentdao;

  public AssignmentModifyHandler(AssignmentDao assignmentdao, Prompt prompt) {
    super(prompt);
    this.assignmentdao = assignmentdao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");
      Assignment oldAssignment = this.assignmentdao.findBy(no);
      if (oldAssignment == null) {
        System.out.println("과제 번호가 유효하지 않습니다.");
        return;
      }

      Assignment assignment = new Assignment();
      assignment.setTitle(this.prompt.input("과제명(%s)? ", oldAssignment.getTitle()));
      assignment.setContent(this.prompt.input("내용(%s)? ", oldAssignment.getContent()));
      assignment.setDeadline(this.prompt.inputDate("제출 마감일(%s)? ", oldAssignment.getDeadline()));

      assignmentdao.update(assignment);

//    } catch (NumberFormatException e) {
//      System.out.println("숫자를 입력하세요");
//
//    } catch (IndexOutOfBoundsException e) {
//      System.out.println("과제 번호가 유효하지 않습니다.");
//
//    } catch (IllegalArgumentException e) {
//      System.out.println("과제 변경 오류");
//      System.out.println("다시 시도 하세요!");

    } catch (Exception e) {
      System.out.println("실행 오류!");
    }
  }
}
