package mystudy.myapp.handler.assignment;

import java.util.ArrayList;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

public class AssignmentModifyHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;

  public AssignmentModifyHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    int index = this.prompt.inputInt("번호? ");
    Assignment oldassignment = this.objectRepository.get(index);
    if (oldassignment == null) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }

    Assignment assignment = new Assignment();
    assignment.setTitle(this.prompt.input("과제명(%s)? ", oldassignment.getTitle()));
    assignment.setContent(this.prompt.input("내용(%s)? ", oldassignment.getContent()));
    assignment.setDeadline(this.prompt.input("제출 마감일(%s)? ", oldassignment.getDeadline()));

    this.objectRepository.set(index, assignment);

  }
}
