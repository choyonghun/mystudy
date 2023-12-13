package mystudy.util;

import java.util.Arrays;

// 게시글 데이터를 보관하는 일을 한다
public class ObjectRepository<E> {

  // 수퍼 클래스이 래퍼런스는 서브 클래스의 인스턴스 주소를 담을수 있다.
  // 따라서 Object레퍼런스는 Member, Board, Assignment 등 어떤 객체의 주소라도 담을수 있다.
  // 목록에 관련된 코드를 외부에서 볼수 없게 감춘다.
  private Object[] objects = new Object[3];
  private int length = 0;

  // 대신 목록에 값을 추가하거나, 꺼내거나, 삭제하려면
  // 메소드를 통해 수행하도록 노력한다
  // 배열에 객체를 추가하는 부분을 메서드로 감춘다.
  //  ==>  캡슐화 한다.
  public void add(E object) {
    if (this.length == this.objects.length) {
      int oldSize = this.objects.length;
      int newSize = oldSize + (oldSize >> 1);

      this.objects = Arrays.copyOf(this.objects, newSize);
      System.out.printf("새 배열크기: %d\n", this.objects.length);

//      Object[] arr = new Object[newSize];
////      System.arraycopy(this.objects, 0, arr, 0, oldSize);
////      System.out.printf("배열크기증가 : %d\n", newSize);

      // 반복문 보다 위에 있는 메소드를 사용한다.
//      for (int i = 0; i < oldSize; i++) {
//        arr[i] = this.objects[i];
//      }
//      this.objects = arr;
    }
    this.objects[this.length++] = object;
  }

  public E remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Object deleted = this.objects[index];

    System.arraycopy(this.objects, index + 1, this.objects, index, this.length - (index + 1));

//    for (int i = index; i < (this.length - 1); i++) {
//      this.objects[i] = this.objects[i + 1];
//    }

    this.objects[--this.length] = null;

    // Board, Member 뭐가 삭제되는지 모르니 E으로 지정해준다. 약간 this. 같은 느낌
    return (E) deleted;
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.objects, this.length);
//    Object[] arr = new Object[this.length];
//    for (int i = 0; i < this.length; i++) {
//      arr[i] = this.objects[i];
//    }
//    return arr;
  }

  public E[] toArray(E[] arr) {
    if (arr.length >= this.length) {
      System.arraycopy(this.objects, 0, arr, 0, this.length);
      return arr;
    }
    return (E[]) Arrays.copyOf(this.objects, this.length, arr.getClass());

//    for (int i = 0; i < this.length; i++) {
//      arr[i] = (E) this.objects[i];
//    }
  }

  public E get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    return (E) this.objects[index];
  }

  public E set(int index, E object) {
    if (index < 0 || index >= this.length) {
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
  public int size() {
    return this.length;
  }

}

