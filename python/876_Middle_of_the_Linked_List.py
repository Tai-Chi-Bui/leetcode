"""
Problem: 876. Middle of the Linked List

Description:
Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes,
return the second middle node.

Requirements:
- Find middle node of linked list
- If two middle nodes, return second one
- Return the middle node

Example:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Constraints:
- The number of nodes in the list is in the range [1, 100]
- 1 <= Node.val <= 100
"""

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    # def middleNode(self, head):
    #     """
    #     :type head: ListNode
    #     :rtype: ListNode
    #     """
    #     res = []
    #     while head:
    #         res.append(head)
    #         head = head.next
    #     return res[len(res) / 2]

    def middleNode(self, head):
        # Fast point is 2 times faster than slow point
        fast = slow = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
