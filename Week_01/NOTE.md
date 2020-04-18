# 学习笔记

## 



## 示例代码 - Deque

使用新Deque API改写课程中的示例代码

```java
Deque<String> deque = new LinkedList<>();

// addLast, removeLast, getLast
deque.addLast("a");
deque.addLast("b");
deque.addLast("c");
System.out.println(deque);

String str1 = deque.getLast();
System.out.println(str1);

while (deque.size() > 0) {
    System.out.println(deque.removeLast());
}
System.out.println(deque);

// offerLast, pollLast, peekLast
deque.offerLast("a");
deque.offerLast("b");
deque.offerLast("c");
System.out.println(deque);

String str2 = deque.peekLast();
System.out.println(str2);

while (deque.size() > 0) {
    System.out.println(deque.pollLast());
}
System.out.println(deque);

// addFirst, removeFirst, getFirst
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str3 = deque.getFirst();
System.out.println(str2);

while (deque.size() > 0) {
    System.out.println(deque.removeFirst());
}
System.out.println(deque);

// offerFirst, pollFirst, peekFirst
deque.offerFirst("a");
deque.offerFirst("b");
deque.offerFirst("c");
System.out.println(deque);

String str4 = deque.peekFirst();
System.out.println(str2);

while (deque.size() > 0) {
    System.out.println(deque.pollFirst());
}
System.out.println(deque);
```