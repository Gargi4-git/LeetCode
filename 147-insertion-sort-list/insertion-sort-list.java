class Solution {
    public ListNode insertionSortList(ListNode head) {

        // Dummy node before the sorted list
        ListNode dummy = new ListNode(0);

        // Current node we are going to insert
        ListNode curr = head;

        while (curr != null) {

            // Save the next node before changing curr.next
            ListNode next = curr.next;

            // Start searching from the beginning of sorted list
            ListNode prev = dummy;

            // Find the correct position
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next unsorted node
            curr = next;
        }

        return dummy.next;
    }
}