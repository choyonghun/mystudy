package mystudy.util;

public class Test {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");

    System.out.println(list.remove("xxx"));
    System.out.println(list.remove("ccc"));
    System.out.println(list.remove("ddd"));
    System.out.println(list.remove("aaa"));
    System.out.println(list.remove("bbb"));

    list.add("xxx");
    list.add("yyy");
    list.add("zzz");

//    System.out.println(list.get(0));
//    System.out.println(list.get(1));
//    System.out.println(list.get(2));
//    System.out.println(list.get(3));
//    System.out.println(list.get(4));
//
//    list.add(0, new String("xxx"));
//    list.add(5, new String("yyy"));
//    list.add(1, new String("mmm"));
//    list.add(3, new String("ttt"));
//    list.add(7, new String("ppp"));
//
//    list.remove(2);
//    list.remove(2);
//    list.remove(0);
//    list.remove(0);

    Object[] arr = list.toArray();
    for (Object value : arr) {
      System.out.printf("%s, ", value);
    }
    System.out.println();

//    Node node = list.first; // 첫번째 노드
//    System.out.println(node.value);
//
//    node = node.next;
//    System.out.println(node.value);
//
//    node = node.next;
//    System.out.println(node.value);
//
//    node = node.next;
//    System.out.println(node.value);
  }
}
