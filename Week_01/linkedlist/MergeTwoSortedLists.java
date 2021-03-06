package linkedlist;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                prev.next = l2;
                l2 = l2.next;
            }
            else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        if (l1 != null) { prev.next = l1; }
        if (l2 != null) { prev.next = l2; }
        return dummy.next;
    }

    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        else if (l2 == null) { return l1; }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }
}

