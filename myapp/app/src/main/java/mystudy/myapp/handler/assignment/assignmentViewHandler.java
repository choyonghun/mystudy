package mystudy.myapp.handler.assignment;

import java.util.List;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

public class assignmentViewHandler extends AbstractMenuHandler {

  private List<Assignment> objectRepository;

  public assignmentViewHandler(List<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    try {
      int index = this.prompt.inputInt("번호? ");

      Assignment assignment = this.objectRepository.get(index);
      System.out.printf("과제명: %s\n", assignment.getTitle());
      System.out.printf("내용: %s\n", assignment.getContent());
      System.out.printf("제출 마감일: %s\n", assignment.getDeadline());

    } catch (Exception e) {
      System.out.println("조회 오류" + e.getMessage());
    }
  }
}
