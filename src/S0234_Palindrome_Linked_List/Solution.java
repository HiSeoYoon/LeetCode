package S0234_Palindrome_Linked_List;

import Common.LinkedList.LinkedListCreator;
import Common.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ListNode input = LinkedListCreator.createLinkedLists("1,2,2,1");
        System.out.println(isPalindrome(input));
    }

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
