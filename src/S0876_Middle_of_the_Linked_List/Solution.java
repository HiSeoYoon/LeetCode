package S0876_Middle_of_the_Linked_List;

import Common.LinkedList.LinkedListCreator;
import Common.LinkedList.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = LinkedListCreator.createLinkedLists("1,2,3,4,5");
        middleNode(head);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode curHead = head;
        int headLen = 1;

        if (head == null) {
            return null;
        }
        while (curHead.next != null) {
            //System.out.println(curHead.val);
            headLen++;
            curHead = curHead.next;
        }
        headLen = headLen / 2;

        curHead = head;
        for (int i = 0; i < headLen; i++) {
            curHead = curHead.next;
        }

        /*System.out.println(curHead.val);
        while (curHead.next != null) {
            curHead = curHead.next;
            System.out.println(curHead.val);
        }*/

        return curHead;
    }
}
