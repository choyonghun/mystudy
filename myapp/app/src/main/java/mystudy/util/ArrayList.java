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

//  2) static 중첩클래스를 사용한 경우
//  @Override
//  public Iterator<E> iterator() {
//    return new IteratorImpl<>(this);   //this는 arraylist 객체를 뜻한다
//  }
//
//
//  private static class IteratorImpl<E> implements Iterator<E> {
//
//    ArrayList<E> list;
//    int cursor;
//
//
//    public IteratorImpl(ArrayList<E> list) {
//      this.list = list;
//    }
//
//
//    @Override
//    public boolean hasNext() {
//      return cursor >= 0 && cursor < list.size();
//    }
//
//    @Override
//    public E next() {
//      return list.get(cursor++);
//    }
//  }

// 3) non-static 중첩클래스를 사용한 경우
// static 메소드는 this라는 변수가 없다. 인스턴스 변수를 받을 this메소드가 업삳.
// static 을 떼면 컴파일러가 바깥클래스를 가져오면서 this메소드와 인스턴스 변수를 가져온다.
//  @Override
//  public Iterator<E> iterator() {
//    return new IteratorImpl<>();   //컴파일러는 ()에 바깥클래스 ArrayList를 가리키는 this를 준다.
//  }
//
//  private class IteratorImpl<E> implements Iterator<E> {
//
//    int cursor;
//
//    @Override
//    public boolean hasNext() {
//      return cursor >= 0 && cursor < ArrayList.this.size();
//      // return false;
//    }
//
//    @Override
//    public E next() {
//      return (E) ArrayList.this.get(cursor++);
//      // return null;
//    }
//  }

  // 4) 로컬 클래스를 사용한 경우
  // 메소드 안에 클래스를 사용하면 그 클래스는 메소드 안에서만 사용 가능하다!
//  @Override
//  public Iterator<E> iterator() {
//    class IteratorImpl<E> implements Iterator<E> {
//
//      int cursor;
//
//      @Override
//      public boolean hasNext() {
//        return cursor >= 0 && cursor < ArrayList.this.size();
//      }
//
//      @Override
//      public E next() {
//        return (E) ArrayList.this.get(cursor++);
//      }
//    }
//    return new IteratorImpl<>();
//  }

//  // 5) 익명 클래스를 사용한 경우
//  @Override
//  public Iterator<E> iterator() {
//    // 익명클래스는 이름이 없기 때문에 정의하는 즉시 인스턴스를 생성해야 한다.
//    Iterator<E> obj = new Iterator<E>() {
//      // 로컬 클래스도 non-static nested 클래스처럼
//      // 바깥 클래스의 인스턴스 주소를 저장하는 코드가 자동으로 추가된다.
//      int cursor;
//      @Override
//      public boolean hasNext() {
//        return cursor >= 0 && cursor < ArrayList.this.size();
//      }
//      @Override
//      public E next() {
//        return (E) ArrayList.this.get(cursor++);
//      }
//    };
//    return obj;
//  }

  // 6) 익명 클래스를 사용한 경우 - 더 간결하게 표현하기
  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      int cursor;

      @Override
      public boolean hasNext() {
        return cursor >= 0 && cursor < ArrayList.this.size();
      }

      @Override
      public E next() {
        return (E) ArrayList.this.get(cursor++);
      }
    };
  }

}
