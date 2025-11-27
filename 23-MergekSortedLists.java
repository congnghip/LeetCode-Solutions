import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; } 
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 ) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode k : lists)
        {
            if(k != null)
            {
                minHeap.offer(k);
            }
        }
        ListNode dummyNode = new ListNode(0);
        ListNode preNode = dummyNode;
        while (!minHeap.isEmpty())
        {
            ListNode curNode = minHeap.poll();
            preNode.next = curNode;
            preNode = preNode.next;
            if (curNode.next != null)
            {
                minHeap.offer(curNode.next);
            }
        }
        return dummyNode.next;
    }
}