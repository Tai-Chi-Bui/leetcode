/*
 * Problem: 876. Middle of the Linked List
 * 
 * Description:
 * Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes,
 * return the second middle node.
 * 
 * Requirements:
 * - Find middle node of linked list
 * - If two middle nodes, return second one
 * - Return the middle node
 * 
 * Example:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * 
 * Constraints:
 * - The number of nodes in the list is in the range [1, 100]
 * - 1 <= Node.val <= 100
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
    // public ListNode middleNode(ListNode head) {
    //     List<ListNode> array = new ArrayList<ListNode>();
    //     while (head != null) {
    //         array.add(head);
    //         head = head.next;
    //     }
    //     return array.get(array.size() / 2);
    // }
    public ListNode middleNode(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
