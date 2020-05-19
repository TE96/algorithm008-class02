package linkedlist;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroupRecursive(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < k) {
            cur = cur.next;
            count ++;
        }
        if (count == k) {
            // 这里的cur已经是下一个子链表翻转后的头结点了
            cur = reverseKGroupRecursive(cur, k);
            while (count > 0) {
                // 翻转链表
                ListNode next = head.next;
                // 第一个头结点连着下一个子链表
                head.next = cur;
                cur = head;
                head = next;
                count --;
            }
            // 经过上面的循环后head应该为null
            // cur为子链表中最后一个节点
            head = cur;
        }
        // 不满足条件则直接返回原来的头结点
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next, n ++);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode prev = dummy, tail = head; n >= k; n -= k) {
            for (int i = 1; i < k; i ++) {
                ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }
            prev = tail;
            tail = tail.next;
        }
        return dummy.next;
    }
}
