package S0160_Intersection_of_Two_Linked_Lists;

import Common.LinkedList.LinkedListCreator;
import Common.LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        ListNode headA = LinkedListCreator.createLinkedLists("4,1,8,4,5");
        ListNode headB = LinkedListCreator.createLinkedLists("4,1,8,4,5");//"5,6,1,8,4,5");

        ListNode output = getIntersectionNode_sol1(headA, headB);
        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }

    public static ListNode getIntersectionNode_sol1(ListNode headA, ListNode headB) {
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

    public static ListNode getIntersectionNode_sol2(ListNode headA, ListNode headB) {
        Set<ListNode> nodesInB = new HashSet<>();

        while (headB != null) {
            nodesInB.add(headB);
            headB = headB.next;
        }

        while (headA != null) {
            if (nodesInB.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
}
