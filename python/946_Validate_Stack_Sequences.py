"""
Problem: 946. Validate Stack Sequences

Description:
Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result
of a sequence of push and pop operations on an initially empty stack, or false otherwise.

Requirements:
- Check if popped sequence is valid for given pushed sequence
- Stack operations: push and pop
- Return true if valid, false otherwise

Example:
Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence: push(1), push(2), push(3), push(4), pop() -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

Constraints:
- 1 <= pushed.length <= 1000
- 0 <= pushed[i] <= 1000
- All the elements of pushed are unique
- popped.length == pushed.length
- popped is a permutation of pushed
"""

class Solution(object):
    def validateStackSequences(self, pushed, popped):
        """
        :type pushed: List[int]
        :type popped: List[int]
        :rtype: bool
        """
        in_stack = []
        pos = 0
        while pos != len(pushed):
            curr = pushed[pos]
            while len(in_stack) > 0 and len(popped) > 0 and in_stack[-1] == popped[0]:
                in_stack.pop(-1)
                popped.pop(0)
            if len(popped) == 0:
                break
            if curr == popped[0]:
                popped.pop(0)
            else:
                in_stack.append(curr)
            pos += 1
        while len(in_stack) > 0 and len(popped) > 0 and in_stack[-1] == popped[0]:
            in_stack.pop(-1)
            popped.pop(0)
        if len(in_stack) == 0:
            return True
        return False


if __name__ == '__main__':
    s = Solution()
    # print s.validateStackSequences([1, 2, 3, 4, 5], [4, 5, 3, 2, 1])
    # print s.validateStackSequences([2, 1, 0], [1, 2, 0])
    print s.validateStackSequences([1, 0, 3, 2], [0, 1, 2, 3])
