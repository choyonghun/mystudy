package mystudy.myapp.dao;

import mystudy.myapp.vo.Member;

public class DaoTest extends AbstractDao<Member> {

  public static void main(String[] args) {
    DaoTest obj = new DaoTest();
    obj.loadData("app/board.json");

    for (Member item : obj.list) {
      System.out.println(item);
    }
  }
}
