package mystudy.myapp.handler.assignment;

import java.util.ArrayList;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

public class AssignmentDeleteHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;

  public AssignmentDeleteHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
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

