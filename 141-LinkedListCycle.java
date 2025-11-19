
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode l = head;
        ListNode r = head;
        if (l == null || l.next == null)
        {
            return false;
        }
        while (l != null && l.next != null)
        {
            r = r.next;
            l = l.next.next;
            if (l == r)
            {
                return true;
            }
        }
        return false;
    }
}