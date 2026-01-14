"""
Problem: 2. Add Two Numbers

Description:
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

Requirements:
- Add two numbers represented as linked lists (digits in reverse order)
- Return the sum as a linked list (also in reverse order)
- Handle carry-over between digits

Example:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807

Constraints:
- The number of nodes in each linked list is in the range [1, 100]
- 0 <= Node.val <= 9
- It is guaranteed that the list represents a number that does not have leading zeros
"""

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    # def addTwoNumbers(self, l1, l2):
    #     """
    #     :type l1: ListNode
    #     :type l2: ListNode
    #     :rtype: ListNode
    #     """
    #     last = 0
    #     head = prev = None
    #     while True:
    #         if l2 is None and l1 is None and last == 0:
    #             break
    #         val = last
    #         if l2 is not None:
    #             val += l2.val
    #             l2 = l2.next
    #         if l1 is not None:
    #             val += l1.val
    #             l1 = l1.next
    #         if val >= 10:
    #             val = val % 10
    #             last = 1
    #         else:
    #             last = 0
    #         current = ListNode(val)
    #         if prev is None:
    #             head = current
    #         else:
    #             prev.next = current
    #         prev = current
    #     return head

    def addTwoNumbers(self, l1, l2):
        carry = 0
        # dummy head
        head = curr = ListNode(0)
        while l1 or l2:
            val = carry
            if l1:
                val += l1.val
                l1 = l1.next
            if l2:
                val += l2.val
                l2 = l2.next
            curr.next = ListNode(val % 10)
            curr = curr.next
            carry = int(val / 10)
        if carry > 0:
            curr.next = ListNode(carry)
        return head.next
