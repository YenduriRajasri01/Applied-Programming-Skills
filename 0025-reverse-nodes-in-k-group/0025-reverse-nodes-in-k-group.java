class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        // Count total nodes
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        curr = head;

        // Process each group
        while (count >= k) {
            ListNode prev = null;
            ListNode groupStart = curr;
            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            // Connect previous group with reversed
            prevGroupEnd.next = prev;
            groupStart.next = curr; // connect end of reversed group to next part
            prevGroupEnd = groupStart;

            count -= k;
        }

        return dummy.next;
    }
}
