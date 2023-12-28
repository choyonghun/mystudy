package mystudy.util;

import java.util.Arrays;

// 게시글 데이터를 보관하는 일을 한다
public class ArrayList<E> extends AbstractList<E> {

  // 수퍼 클래스이 래퍼런스는 서브 클래스의 인스턴스 주소를 담을수 있다.
  // 따라서 Object레퍼런스는 Member, Board, Assignment 등 어떤 객체의 주소라도 담을수 있다.
  // 목록에 관련된 코드를 외부에서 볼수 없게 감춘다.
  private Object[] objects = new Object[3];
  // private int length = 0;

  // 대신 목록에 값을 추가하거나, 꺼내거나, 삭제하려면
  // 메소드를 통해 수행하도록 노력한다
  // 배열에 객체를 추가하는 부분을 메서드로 감춘다.
  //  ==>  캡슐화 한다.
  public void add(E object) {
    if (this.size == this.objects.length) {
      int oldSize = this.objects.length;
      int newSize = oldSize + (oldSize >> 1);

      this.objects = Arrays.copyOf(this.objects, newSize);
      System.out.printf("새 배열크기: %d\n", this.objects.length);

    }
    this.objects[this.size++] = object;
  }

  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    Object deleted = this.objects[index];

    System.arraycopy(this.objects, index + 1, this.objects, index, this.size - (index + 1));

    this.objects[--this.size] = null;

    // Board, Member 뭐가 삭제되는지 모르니 E으로 지정해준다. 약간 this. 같은 느낌
    return (E) deleted;
  }

  public boolean remove(E value) {
    for (int i = 0; i < this.size; i++) {
      if (this.objects[i].equals(value)) {
        this.remove(i);
        return true;    //찾아서 배열에서 제거했으면 true를 리턴
      }
    }
    return false;
  }


  public Object[] toArray() {
    return Arrays.copyOf(this.objects, this.size);
  }

  public E[] toArray(E[] arr) {
    if (arr.length >= this.size) {
      System.arraycopy(this.objects, 0, arr, 0, this.size);
      return arr;
    }
    return (E[]) Arrays.copyOf(this.objects, this.size, arr.getClass());
  }

  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.objects[index];
  }

  public E set(int index, E object) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    Object old = this.objects[index];
    this.objects[index] = object;

    // 새 객체로 교체하기 전에 이전 객체를 리턴한다.
    // 호출하는 쪽에서 받아 쓰거나 말거나 알아서 해라!
    return (E) old;
  }

  // 남의 클래스의 변수에 접근하는 코드가 있으면
  // 그 코드를 그 클래스로 옮겨라
  // 상속 받았으니깐 주석처리 해주기!!
//  public int size() {
//    return this.size;
//  }

}

