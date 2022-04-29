package S0141_Linked_List_Cycle;

import Common.LinkedList.LinkedListCreator;
import Common.LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        ListNode input = LinkedListCreator.createLinkedLists("3,2,0,-4");
        hasCycle(input);
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle_2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
