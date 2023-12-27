package mystudy.util;

public class LinkedList<E> {

  private Node<E> first;
  private Node<E> last;
  private int size;

  public int size() {
    return size;
  }

  public void add(E value) {
    Node<E> node = new Node<>();      // 제네릭 타입 E를 가지는 Node 객체 생성
    node.value = value;               // 메서드로 전달된 value을 새로운 노드 value 필드에 할당하는 역할
    // 새로운 노드에 원하는 값을 저장할수 잇다.
    if (last == null) {               // last가 null 값인 경우
      first = last = node;            // 리스트가 비어 있는경우 첫번째노드를 first, 마지막노드를 last로 지정한다.
    } else {                          // 리스트가 비어있지 않는 경우
      last.next = node;               // last.next를 새로운 노드로 설정해 새로운 노드를 리스트에 추가
      last = node;                    // last를 새로 추가된 노드로 업데이트, 새로운 노드가 리스트의 마지막 노드가 된다.
    }
    size++;                           // list의 크기를 증가 시킨다.
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];          // object배열생성
    int index = 0;                            // index를 0으로 초기화
    Node node = first;                        // 첫번째 노드를 가리키는 노드객체 생성
    while (node != null) {                    // 노드가 null이 아닌동안 반복 => 리스트 끝 도달까지 반복한다.
      arr[index++] = node.value;              // 현재 노드값을 배열에 저장하고 인덱스 증가한다.
      node = node.next;                       // 현재 노들르 다음 노드로 업데이트해 리스트를 이동시킨다.
    }
    return arr;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {         //0보다 작거나 인덱스가 리스트틔 크기를 벗어나면 예외를 던진다.
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }
    int cursor = 0;                     // cursor를 0으로 초기화
    Node<E> node = first;               // 첫번째노드를 가리키는 node 객체를 생성
    while (++cursor <= index) {         // cursor를 1씩 증가시키면서 현재 노드를 다믕 노드로 업데이트한다.
      node = node.next;                 // 주어진 인덱스에 도달할때까지 반복한다.
    }
    return node.value;                  // 주어진 인덱스에 해당하는 노드값을 반환한다.
  }

  public Object set(int index, E value) {
    if (index < 0 || index >= size) {         //0보다 작거나 인덱스가 리스트틔 크기를 벗어나면 예외를 던진다.
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    int cursor = 0;                     // cursor 0으로 초기화
    Node<E> node = first;               // 첫번째 노드를 가리키는 node 객체 생성
    while (++cursor <= index) {         // cursor을 1씩 늘리면서 현재노드를 다음노드로 업데이트
      node = node.next;                 // 주어진 인덱스에 도달할때까지 반복
    }

    Object old = node.value;            // 현재 노드 값을 old에 저장 변경이전의 값을 기억하기 위한
    node.value = value;                 // 현재 노드의 값을 새로운 value으로 변경
    return old;                         // 변경 전의 값을 저장한 old 변수를 리턴시킨다.
  }

  public void add(int index, E value) {
    // 인덱스가 음수이거나 리스트 크기보다 크면 무효해 에외를 던진다.
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node<E> node = new Node<>();   //node 객체 생성
    node.value = value;       //value값 할당

    // 리스트가 비어있는 경우 새로운 노드를 리스트 첫번째 노드로 설정하고,
    // 리스트가 비어있어면 새로운 노드를 first,last에 지정해준다.
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

      // 인덱스가 0이나 인덱스크기가 리스트 크기보다 작을 경우 주어진 인덱스를 새로운 노드에 넣어준다.
      // 반복문을 사용해 이전노드를 찾고 그뒤에 새로운 노드를 넣어준다.
    } else {
      int cursor = 0;
      Node<E> currNode = first;       // linkedlist의 첫번째 노드를 가리키는 currNode객체생성
      while (++cursor < index) {      // currsor를 1씩 증가 시키면서 다음 노드로 업데이트
        currNode = currNode.next;     // 주어진 인덱스를 찾을때 까지 반복
      }                               // 반복문을 나가면 주어진 인덱스의 이전 노드를 가리키게된다.
      node.next = currNode.next;      // 새로운노드의 next를 현재노드의next로 설정 새로운 노드는 주어진 인덱스이전의 노드의 next에 위치한다.
      currNode.next = node;           // 주어진 인덱스 이전의 노드next를 새로운 노드로 설정, 새로운 노드가 리스트에 추가된다.
    }
    size++;                           // size 1씩 증가시킨다.
  }


  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    E old = null;               //변수 old를 선언하고 초기화 시킨다.

    // 1개 일 때
    if (size == 1) {              // 리스트에 노드가 1개일 경우
      old = first.value;          // 리스트를 비우고 삭제된 노드 값을 old에 저장한다.
      first = last = null;

      //2개 이상있을때 첫번째꺼를 삭제하고 삭제된 노드값을 old에 저장한다.
    } else if (index == 0) {
      old = first.value;
      first = first.next;

      // 중간이나 마지막 모드를 삭제하는 경우
    } else {
      int cursor = 0;                       // cursor 0으로 초기화
      Node<E> currNode = first;             // 첫번째 노드를 가리키는 currNode객체를 생성
      while (++cursor < index) {            // currsor를 1씩 증가시키며 현재 노드를 다음 노드로 업데이트 한다.
        currNode = currNode.next;           // 이전 노드를 찾을때 까지 반복한다. 반복문을 나가면 currNode는 인덱스의 이전노드를 가리킨다.
      }
      old = currNode.next.value;              // 삭제할 노드의 값을 old에 저장한다. currNode.next는 현재노드의 다음노드를 가리킨다
      // 이것을 통해 삭제할 노드에 접근한다.
      currNode.next = currNode.next.next;     // 삭제할 노드를 건너뒤어 다음 노드로 연결한다.
      // 이것을 통해 삭제할 노드가 리스트에서 제거된다.
      if (index == (size - 1)) {              // 삭제한 노드가 마지막 노드인 경우
        last = currNode;                      // last를 이전 노드로 업데이트 하여 last를 이전 노드를 가리키게된다.
      }
    }
    size--;                                   // 마지막 노드가 삭제되었으니 그 칸은 지운다.
    return old;                               // 삭제된 값 리턴
  }


  public boolean remove(E value) {
    Node prevNode = null;                 //이전 노드를 가리키는 prevNode를 null로 초기화
    Node node = first;                    //현재 노드를 가리키는 node를 first로 초기화

    while (node != null) {                // node가 null이 아닌동안 반복한다.
      if (node.value.equals(value)) {     // 주어진 값과 일치할때까지 반복
        break;                            // 찾으면 반복문 종료
      }
      prevNode = node;                    // 현재 노드를 이전 노드로 저장, prevNode는 현재 노드를 가리킨다.
      node = node.next;                   // node.next는 다음노드를 가리킨다.
    }

    if (node == null) {                   // 리스트를 끝까지 순회했음에도 값을 가진 노드를 못찾을경우
      return false;                       // false를 리턴해주고 메서드를 종료한다.
    }

    if (node == first) {                  // 찾는 값이 리스트 첫번째 노드에 있는 경우
      first = first.next;                 // 리스트 첫번째 노드를 삭제하고
      if (first == null) {                // 만약 리스트가 빈 상태라면
        last = null;                      // last도 null로 업데이트 한다.
      }
    } else {                              // 찾는값이 첫번째 노드가 아닌경우
      prevNode.next = node.next;          // 이전노드next를 현재노드next로 설정하여
    }                                     //  현재노드를 건너뛰어 삭제한다

    size--;                               // 노드가 성공적으로 삭제되면 리스트의 크기를 감소시킨다.
    return true;                          // 메서드가 정상적으로 실행되어 값을 찾아 삭제했으면 true 반환
  }

  // 중첩클래스중첩클래스중첩클래스중첩클래스중첩클래스중첩클래스중첩클래스중첩클래스
  private static class Node<E> {

    E value;            // 노드가 저장하는 값
    Node<E> next;       // 다음 노드를 가리키는 링크
  }
}
