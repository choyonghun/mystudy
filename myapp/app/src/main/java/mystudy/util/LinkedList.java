package mystudy.util;

public class LinkedList<E> {

  private Node<E> first;
  private Node<E> last;
  private int size;

  public int size() {
    return size;
  }

  public void add(E value) {
    Node<E> node = new Node<>();
    node.value = value;

    if (last == null) {
      // 노드 객체가 없을 때,
      first = last = node;
    } else {
      // 기존에 노드 객체가 있을 때,
      // 마지막 노드의 다음 노드로 새로 만든 노드를 가리키게 한다.
      last.next = node;
      last = node;
    }
    size++;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    int index = 0;
    Node node = first;
    while (node != null) {
      arr[index++] = node.value;
      node = node.next;
    }
    return arr;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    int cursor = 0;
    Node<E> node = first;
    while (++cursor <= index) {
      node = node.next;
    }

    return node.value;
  }

  public Object set(int index, E value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    int cursor = 0;
    Node<E> node = first;
    while (++cursor <= index) {
      node = node.next;
    }

    Object old = node.value;
    node.value = value;
    return old;
  }

  public void add(int index, E value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node<E> node = new Node<>();   //node 객체 생성
    node.value = value;       //value값 할당

    // 리스트가 비어있는 경우 새로운 노드를 리스트 첫번째 노드로 설정하고,
    // first,last에 새로운 노드 지정해준다.
    if (first == null) {
      first = last = node;

      // 인덱스가 0 인경우 맨앞에 새로운 노드를 추가하고 first를 업데이트한다.
    } else if (index == 0) {
      node.next = first;
      first = node;

      // 인덱스가 리스트 크기와 같은 경우 리스트 맨 끝에 새로운 노드를 추가하고 last를 업데이트 한다.
    } else if (index == size) {
      last.next = node;
      last = node;

    } else {
      int cursor = 0;
      Node<E> currNode = first;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      node.next = currNode.next;
      currNode.next = node;
    }
    size++;
  }


  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    E old = null;

    // 1개 일 때
    if (size == 1) {
      old = first.value;
      first = last = null;

      //2개 이상있을때 첫번째꺼를 두번째로 이동한다  맨앞에꺼 삭제
    } else if (index == 0) {
      old = first.value;
      first = first.next;

    } else {
      int cursor = 0;
      Node<E> currNode = first;
      //삭제할 인덱스 전까지만 찾는다.
      while (++cursor < index) {
        currNode = currNode.next;
      }
      old = currNode.next.value;
      currNode.next = currNode.next.next;

      if (index == (size - 1)) {
        last = currNode;
      }
    }
    size--;
    return old;
  }


  public boolean remove(E value) {
    Node prevNode = null;
    Node node = first;

    while (node != null) {
      if (node.value.equals(value)) {
        break;
      }
      prevNode = node;
      node = node.next;
    }

    if (node == null) {
      return false;
    }

    if (prevNode == null) {
      first = node.next;
    }

    if (node == first) {
      first = first.next;
      if (first == null) {
        last = null;
      }
    } else {
      prevNode.next = node.next;
    }

    size--;
    return true;
  }

  private static class Node<E> {

    E value;
    Node<E> next;
  }


}
