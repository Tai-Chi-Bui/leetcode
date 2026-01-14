/*
 * Problem: 19. Remove Nth Node From End of List
 * 
 * Description:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * 
 * Requirements:
 * - Remove the nth node from the end of the linked list
 * - Return the head of the modified list
 * - n is always valid
 * 
 * Example:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * 
 * Input: head = [1], n = 1
 * Output: []
 * 
 * Constraints:
 * - The number of nodes in the list is sz
 * - 1 <= sz <= 30
 * - 0 <= Node.val <= 100
 * - 1 <= n <= sz
 * 
 * Follow up: Could you do this in one pass?
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int ls = 0;
        while (curr != null) {
            curr = curr.next;
            ls++;
        }
        // n == len
        if (ls == n) {
            if (ls > 1) return head.next;
            return null;
        }
        curr = head;
        // Move to ls - n - 1
        for (int i = 0; i < ls - n - 1; i++) {
            curr = curr.next;
        }
        // Remove ls - n - 1
        curr.next = curr.next.next;
        return head;
    }*/

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow, fast, curr;
        slow = head; fast = head;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        // n == len
        if (fast == null) {
            head = head.next;
            return head;
        }
        // Move both pointers, until reach tail
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        curr = slow.next;
        slow.next = curr.next;
        return head;
    }
}
