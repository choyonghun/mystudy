package mystudy.myapp.handler.assignment;

import java.util.ArrayList;
import mystudy.menu.AbstractMenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
public class AssignmentAddHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;

  public AssignmentAddHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {
    Assignment assignment = new Assignment();
    assignment.setTitle(this.prompt.input("과제명? "));
    assignment.setContent(this.prompt.input("내용? "));
    assignment.setDeadline(this.prompt.input("제출 마감일? "));

    objectRepository.add(assignment);
  }
}
