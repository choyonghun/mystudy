package mystudy.myapp.handler.assignment;

import mystudy.menu.Menu;
import mystudy.menu.MenuHandler;
import mystudy.myapp.vo.Assignment;
import mystudy.util.AnsiEscape;
import mystudy.util.Prompt;

public class AssignmentModifyHandler implements MenuHandler {

  AssignmentRepository assignmentRepository;
  Prompt prompt;

  public AssignmentModifyHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    Assignment oldassignment = this.assignmentRepository.get(index);
    if (oldassignment == null) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }

    Assignment assignment = new Assignment();
    assignment.title = this.prompt.input("과제명(%s)? ", oldassignment.title);
    assignment.content = this.prompt.input("내용(%s)? ", oldassignment.content);
    assignment.deadline = this.prompt.input("제출 마감일(%s)? ", oldassignment.deadline);

    this.assignmentRepository.set(index, assignment);

  }
}
