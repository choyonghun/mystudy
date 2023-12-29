package mystudy.util;

public class LinkedListIterator<E> implements Iterator<E> {

  LinkedList<E> list;
  int cursor;

  public LinkedListIterator(LinkedList<E> list) {
    this.list = list;
  }

  @Override
  public boolean hasNext() {
    return cursor >= 0 && cursor < list.size();
  }

  // LinkedList에서 값을 꺼내느것은 비효율적이다.
  @Override
  public E next() {
    return list.get(cursor++);    //LinkedList에 있는 cursor를 꺼내서 하나씩 증가
  }
}
