package S0019_Remove_Nth_Node_From_End_of_List;

import Common.LinkedList.LinkedListCreator;
import Common.LinkedList.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode input = LinkedListCreator.createLinkedLists("1,2,3,4,5");
        removeNthFromEnd_1(input, 2);
    }

    public static ListNode removeNthFromEnd_1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
