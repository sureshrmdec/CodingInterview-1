/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.

 * Your algorithm should use only constant space. You may not modify the values in the list, 
 * only nodes itself can be changed.
 * 
 * Tag: LinkedList
 * @author wendi
 *
 */
public class SwapNodesinPairs {

	/**
	 * Brute force
	 * @param ListNode head
	 * @return ListNode
	 * Time: O(n)
	 * Space: O(1)
	 */
	public ListNode swapNodesinPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode odd = prev.next;
            ListNode even = prev.next.next;
            odd.next = even.next;
            even.next = prev.next;
            prev.next = even;
            prev = odd;
        }
        return dummy.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapNodesinPairs result = new SwapNodesinPairs();
		ListNode head1 = ListNode.generateLinkedList(new int[] {1, 2, 3, 4});
		ListNode.printLinkedList(result.swapNodesinPairs(head1));
		ListNode head2 = ListNode.generateLinkedList(new int[] {1, 2, 3, 4, 5});
		ListNode.printLinkedList(result.swapNodesinPairs(head2));		
	}

}
