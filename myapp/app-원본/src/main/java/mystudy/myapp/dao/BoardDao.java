package mystudy.myapp.dao;

import java.util.List;
import mystudy.myapp.vo.Board;

public interface BoardDao {

  void add(Board board);

  int delete(int no);

  List<Board> findAll();

  Board findBy(int no);

  int update(Board board);

}
