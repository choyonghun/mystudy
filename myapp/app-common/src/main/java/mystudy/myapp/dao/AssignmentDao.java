package mystudy.myapp.dao;

import java.util.List;
import mystudy.myapp.vo.Assignment;

public interface AssignmentDao {

  void add(Assignment assignment);

  int delete(int no);

  List<Assignment> findAll();

  Assignment findBy(int no);

  int update(Assignment assignment);


}
