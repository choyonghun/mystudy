package mystudy.myapp.handler.board;

import mystudy.myapp.vo.Board;

// 게시글 데이터를 보관하는 일을 한다
public class BoardRepository {

  // 목록에 관련된 코드를 외부에서 볼수 없게 감춘다.
  private Board[] boards = new Board[3];
  private int length = 0;

  // 대신 목록에 값을 추가하거나, 꺼내거나, 삭제하려면
  // 메소드를 통해 수행하도록 노력한다
  // 배열에 객체를 추가하는 부분을 메서드로 감춘다.
  //  ==>  캡슐화 한다.
  public void add(Board board) {
    if (this.length == this.boards.length) {
      int oldSize = this.boards.length;
      int newSize = oldSize + (oldSize >> 1);

      Board[] arr = new Board[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.boards[i];
      }
      this.boards = arr;
    }
    this.boards[this.length++] = board;
  }

  public Board remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Board deleted = this.boards[index];

    for (int i = index; i < (this.length - 1); i++) {
      this.boards[i] = this.boards[i + 1];
    }
    this.boards[--this.length] = null;

    return deleted;
  }

  public Board[] toArray() {
    Board[] arr = new Board[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.boards[i];
    }
    return arr;
  }

  public Board get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    return this.boards[index];
  }

  public Board set(int index, Board board) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    Board old = this.boards[index];
    this.boards[index] = board;

    // 새 객체로 교체하기 전에 이전 객체를 리턴한다.
    // 호출하는 쪽에서 받아 쓰거나 말거나 알아서 해라!
    return old;
  }
}

