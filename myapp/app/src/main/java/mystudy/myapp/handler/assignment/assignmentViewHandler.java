package mystudy.myapp.handler.assignment;

import java.util.ArrayList;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

public class assignmentViewHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;

  public assignmentViewHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    int index = this.prompt.inputInt("번호? ");

    Assignment assignment = this.objectRepository.get(index);
    if (assignment == null) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("과제명: %s\n", assignment.getTitle());
    System.out.printf("내용: %s\n", assignment.getContent());
    System.out.printf("제출 마감일: %s\n", assignment.getDeadline());
  }
}
