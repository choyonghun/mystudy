package mystudy.util;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool implements Pooling<WorkerThread> {

  List<WorkerThread> list = new ArrayList<>();

  @Override
  public WorkerThread get() {
    if (list.size() > 0) {
      return list.remove(0);
    }
    WorkerThread thread = new WorkerThread(this);
    thread.start();
    return thread;
  }

  @Override
  public void revert(WorkerThread thread) {
    list.add(thread);
  }

  private WorkerThread create() {
    WorkerThread thread = new WorkerThread(this);
    thread.start();
    try {
      Thread.sleep(500);  // 스레드가 wait할 시간을 준다.
    } catch (Exception e) {
    }
    System.out.printf("새 스레드 생성!(%s)\n", thread.getName());
    return thread;
  }

}
