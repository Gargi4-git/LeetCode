class Solution {
    public ListNode sortList(ListNode head) {

        // 0 or 1 node = already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split into two lists
        ListNode mid = slow.next;
        slow.next = null;

        // Sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // Merge
        return merge(left, right);
    }

    private ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (a != null && b != null) {

            if (a.val <= b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }

            current = current.next;
        }

        // Attach remaining nodes
        if (a != null) {
            current.next = a;
        } else {
            current.next = b;
        }

        return dummy.next;
    }
}