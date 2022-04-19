package S0160_Intersection_of_Two_Linked_Lists;

import Common.LinkedList.LinkedListCreator;
import Common.LinkedList.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode headA = LinkedListCreator.createLinkedLists("4,1,8,4,5");
        ListNode headB = LinkedListCreator.createLinkedLists("5,6,1,8,4,5");

        ListNode output = getIntersectionNode(headA, headB);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode pB = headB;
            while (pB != null) {
                if (headA == pB) return headA;
                pB = pB.next;
            }
            headA = headA.next;
        }
        return null;
    }
}
