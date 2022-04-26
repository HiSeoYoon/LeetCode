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
}
