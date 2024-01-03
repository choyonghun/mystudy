package mystudy.myapp.handler.assignment;

import java.util.List;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

public class AssignmentDeleteHandler extends AbstractMenuHandler {

  private List<Assignment> objectRepository;

  public AssignmentDeleteHandler(List<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    try {
      int index = this.prompt.inputInt("번호? ");
      this.objectRepository.remove(index);
    } catch (Exception e) {
      System.out.println("삭제 오류~!!!~");
    }
  }
}

