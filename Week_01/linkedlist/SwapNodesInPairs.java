package linkedlist;

public class SwapNodesInPairs {

    public ListNode swapPairsIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            ListNode second = head.next;
            head.next = second.next;
            second.next = head;
            prev.next = second;

            prev = head;
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head, second = head.next;
        first.next = swapPairsRecursive(second.next);
        second.next = first;
        return second;
    }
}
