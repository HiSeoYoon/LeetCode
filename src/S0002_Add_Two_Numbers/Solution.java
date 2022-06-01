package S0002_Add_Two_Numbers;

import Common.LinkedList.LinkedListCreator;
import Common.LinkedList.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode input1 = LinkedListCreator.createLinkedLists("2,4,3");
        ListNode input2 = LinkedListCreator.createLinkedLists("5,6,4");
        ListNode output = addTwoNumbers_1(input1, input2);

        while (output != null) {
            System.out.println("result : " + output.val);
            output = output.next;
        }

    }

    public static ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
