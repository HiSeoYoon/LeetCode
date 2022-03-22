package S0203_Removed_Linked_List_Elements;

import Common.LinkedList.LinkedListCreator;
import Common.LinkedList.ListNode;

public class Solutions {
    public static void main(String[] args) {
        ListNode head = LinkedListCreator.createLinkedLists("1,2,6,3,4,5,6");
        removeElements(head, 6);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode removedList = new ListNode(0);
        removedList.next = head;

        ListNode prev = removedList, curr = head;
        while (curr != null) {
            //System.out.println(head.val);
            if (head.val == val) {
                prev.next = curr.next;
            } else prev = curr;
            curr = curr.next;
        }
        return removedList.next;
    }
}
