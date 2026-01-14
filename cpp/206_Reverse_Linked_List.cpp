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
 * Input: head = [1,2]
 * Output: [2,1]
 * 
 * Constraints:
 * - The number of nodes in the list is the range [0, 5000]
 * - -5000 <= Node.val <= 5000
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *reverseList(ListNode *head) {
        if (head == NULL)
            return NULL;
        if (head->next == NULL)
            return head;
        // Previous pointer
        ListNode *previous = head;
        // Current pointer
        ListNode *curr = head->next;
        head->next = NULL;
        while (curr->next) {
            ListNode *next = curr->next;
            curr->next = previous;
            previous = curr;
            curr = next;
        }
        curr->next = previous;
        return curr;
    }
};
