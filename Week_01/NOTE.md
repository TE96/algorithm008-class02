# 学习笔记

本周是算法训练营的第一周，学习的内容包括以下部分：

- 学习方法
- 数组、链表、跳表实现及实战
- 栈、队列、优先队列、双端队列及实战

## 学习方法

本次算法训练是职业训练，目的是熟练而不仅仅是会做，需要严格遵守以下学习方式：

- 切碎知识点
- 刻意练习
- 反馈

### 切碎知识点

将庞大的知识体系，分解成清晰、脉络化的知识脑图（类似书的目录），内容必须脉络相连。能够根据脑图内容，回想细节，如栈的操作及其复杂度。

### 刻意练习

刷题方法如下：

切题4件套

- 明确问题：用5-10分钟读题和思考，确保自己对题目的理解是正确的
- 可能的解决方式：比较不同算法的时间、空间复杂度，取其最优解
- 编写代码
- 测试

5遍刷题法（过遍数，而不是每次花很长时间）

- 第1遍：15分钟内没有思路，直接看题解。比较解法优劣后，背诵、默写好的解法
- 第2遍：马上自己写代码，并在LeetCode上提交，尝试多种解法并优化代码
- 第3遍：1天后重复做题，针对不同解法的熟练程度做专项练习
- 第4遍：1周后重复做题
- 第5遍：面试前恢复性训练，根据自己情况安排时间

### 反馈

- 即时反馈
- 主动型反馈：自己去找Github、LeetCode优秀代码
- 被动式反馈：code review

### 误区

三分看视频理解、七分练习

- 1.5倍速-2.0倍速播放，难点反复观看

摒弃“旧”习惯

- 不要死磕，要敢于死记硬背
- LeetCode题目不能只做一遍
- 不懒于看高手代码

## 数组实战

对于数组的题目，暴力解法一般有两种思路

- 循环遍历数组元素：如三数之和
- 排序：如删除排序数组中的重复项、合并两个有序数组

这样的解法一般会有很多重复计算，没有利用题目给出的条件。

如果题目已经给了排序好的数组，可以考虑用多个变量过滤不必要的计算：

- 在移动零中，由于非零元素数量≤元素数量，用一个变量维护非零元素的最终位置，在迭代中遇到非零元素时更新这个变量，最后补零就能达到移动零的效果。

- 在盛最多水的容器，暴力枚举两个边界计算了所有可能的面积，其中包括已经不可能成为最大值的情况。这里官方题解进行了正确性证明，通过左右指针向内夹逼从而只需$O(n)$的复杂度即可完成。
- 在三数之和中3个变量的情况，暴力枚举$O(n^3)$的算法同样包括不需要的计算，这里排除不可能成为解的情况所使用的方法是排序，尽管需要$O(nlogn)$的时间，但换来的是最终复杂度为$O(n^2)$的算法。将左边界$k$看成是不动的，剩余两个变量$i$，$j$从边界向里夹逼的思想，有些类似快速排序中的分区算法。

此外在爬楼梯中，提供了数学归纳法的思想。该题很难暴力枚举，可以考虑重复部分，即$n$阶楼梯只能从$n-1$和$n-2$阶楼梯，通过公式$f(n)=f(n-1)+f(n-2)$得到结果。

## 链表实战

对于链表的题目，暴力解法一般也是枚举链表元素（如反转链表，先找到最后一个结点，再找到倒数第二个）

通常链表的操作都是对next指针的处理，对于反转链表，由于单链表没有prev的信息，因此无法反向进行迭代，从而有高效的双指针解法和递归解法。

双指针一般是快慢指针，两个指针的移动速度可能相同，也可能不同。

- 在反转链表中，快指针负责当前要处理的节点以及进度推进，慢指针保存prev信息，在处理快指针时由于新的`next`将会指向prev，所以需要提前保存下一个节点的信息，在处理完成后赋值给快指针，从而可以一次正向迭代即可完成反转；而在递归算法中，保存next信息的正是发生递归处的返回值，这利用了栈了先入后出特性，递归到基本情况时返回的顺序正好和当前链表顺序相反。
- 在环形链表中，通过快慢指针移动速度不同，在有环的情况下慢指针会被追上从而只需要$O(n)$的复杂度即可判断是否有环

# 作业

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