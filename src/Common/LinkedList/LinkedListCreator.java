package Common.LinkedList;

public class LinkedListCreator {
    public static void main(String[] args) {
        ListNode node = LinkedListCreator.createLinkedLists("1,2,3,4,5");
        System.out.println(node.toString());
    }

    /**
     * @param ll is comma-separated values (e.g, input 1,2,3 will make chained LinkedList 1 -> 2 -> 3)
     * @return the first node of LinkedLists
     */
    public static ListNode createLinkedLists(String ll) {
        String[] nodeValues = ll.split(",");
        ListNode head = new ListNode(Integer.parseInt(nodeValues[0]));
        ListNode temp = head;
        for (int i = 1; i < nodeValues.length; i++) {
            ListNode node = new ListNode(Integer.parseInt(nodeValues[i]));
            temp.next = node;
            temp = node;
        }
        return head;
    }
}
