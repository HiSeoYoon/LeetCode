package S0234_Palindrome_Linked_List;

import Common.LinkedList.LinkedListCreator;
import Common.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ListNode input = LinkedListCreator.createLinkedLists("5,6,1,7,5");//1,2,2,1");
        System.out.println(isPalindrome_sol3(input));
    }


    public static boolean isPalindrome_sol1(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    //----------------------------------------------------------//

    private static ListNode frontPointer;

    public static boolean isPalindrome_sol2(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private static boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    //----------------------------------------------------------//

    public static boolean isPalindrome_sol3(ListNode head) {
        if (head == null) return true;

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //----------------------------------------------------------//

    public static boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        ListNode nextHead = head;
        while (nextHead != null) {
            vals.add(nextHead.val);
            nextHead = nextHead.next;
        }

        int valsSize = vals.size();
        for (int i = 0; i < Math.floor(valsSize / 2); i++) {
            if (vals.get(i) != vals.get(valsSize - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
