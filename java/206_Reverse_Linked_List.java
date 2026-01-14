/*
 * Problem: 206. Reverse Linked List
 * 
 * Description:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Requirements:
 * - Reverse a singly linked list
 * - Return the head of the reversed list
 * - Modify the list in-place
 * 
 * Example:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 * Constraints:
 * - The number of nodes in the list is the range [0, 5000]
 * - -5000 <= Node.val <= 5000
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution
    public ListNode reverseList(ListNode head) {
        // Iterative solution
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    
    // Recursive
    /*
    public ListNode reverseList(ListNode head) {
        return reverseListInt(head, null);
    }
    
    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }*/
}
