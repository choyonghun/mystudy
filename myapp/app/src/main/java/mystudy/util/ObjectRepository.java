package mystudy.util;

// 게시글 데이터를 보관하는 일을 한다
public class ObjectRepository {

  // 목록에 관련된 코드를 외부에서 볼수 없게 감춘다.
  private Object[] objects = new Object[3];
  private int length = 0;

  // 대신 목록에 값을 추가하거나, 꺼내거나, 삭제하려면
  // 메소드를 통해 수행하도록 노력한다
  // 배열에 객체를 추가하는 부분을 메서드로 감춘다.
  //  ==>  캡슐화 한다.
  public void add(Object object) {
    if (this.length == this.objects.length) {
      int oldSize = this.objects.length;
      int newSize = oldSize + (oldSize >> 1);

      Object[] arr = new Object[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.objects[i];
      }
      this.objects = arr;
    }
    this.objects[this.length++] = object;
  }

  public Object remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Object deleted = this.objects[index];

    for (int i = index; i < (this.length - 1); i++) {
      this.objects[i] = this.objects[i + 1];
    }
    this.objects[--this.length] = null;

    return deleted;
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.objects[i];
    }
    return arr;
  }

  public Object get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    return this.objects[index];
  }

  public Object set(int index, Object Object) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    Object old = this.objects[index];
    this.objects[index] = Object;

    // 새 객체로 교체하기 전에 이전 객체를 리턴한다.
    // 호출하는 쪽에서 받아 쓰거나 말거나 알아서 해라!
    return old;
  }
}

