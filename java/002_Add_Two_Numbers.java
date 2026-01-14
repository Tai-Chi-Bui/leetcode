/*
 * Problem: 2. Add Two Numbers
 * 
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * 
 * Requirements:
 * - Add two numbers represented as linked lists (digits in reverse order)
 * - Return the sum as a linked list (also in reverse order)
 * - Handle carry-over between digits
 * 
 * Example:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807
 * 
 * Constraints:
 * - The number of nodes in each linked list is in the range [1, 100]
 * - 0 <= Node.val <= 9
 * - It is guaranteed that the list represents a number that does not have leading zeros
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // example in leetcode book
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dummyHead = new ListNode(0);
    	ListNode p = l1, q= l2, curr = dummyHead;
    	int carry = 0;
    	while (p != null || q!= null) {
    		int x = (p != null) ? p.val : 0;
    		int y = (q != null) ? q.val : 0;
    		int digit = carry + x + y;
    		carry = digit / 10;
    		curr.next = new ListNode(digit % 10);
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
