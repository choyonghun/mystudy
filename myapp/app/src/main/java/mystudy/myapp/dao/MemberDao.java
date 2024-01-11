package mystudy.myapp.dao;

import java.util.List;
import mystudy.myapp.vo.Member;

public interface MemberDao {

  void add(Member member);

  int delete(int no);

  List<Member> findAll();

  Member findBy(int no);

  int update(Member member);

}
