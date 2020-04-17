/**
 * 思路：
 * 只要修改每个节点的next信息。
 * 当前节点的next即为前一个节点，可以使用一个指针保存
 * 在修改next之前需要需要保存next信息以迭代原链表
 * @author fuwuchen
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
