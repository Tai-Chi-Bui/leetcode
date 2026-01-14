"""
Problem: 872. Leaf-Similar Trees

Description:
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
Two binary trees are considered leaf-similar if their leaf value sequence is the same. Return true if and only if the two
given trees with head nodes root1 and root2 are leaf-similar.

Requirements:
- Check if two trees have same leaf value sequence
- Leaves are from left to right
- Return true if leaf sequences match, false otherwise

Example:
Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true

Constraints:
- The number of nodes in each tree will be in the range [1, 200]
- Both of the given trees will have values in the range [0, 200]
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def leafSimilar(self, root1, root2):
        """
        :type root1: TreeNode
        :type root2: TreeNode
        :rtype: bool
        """
        if not root1 and not root2:
            return True
        leaf1 = []
        leaf2 = []
        self.dfs(root1, leaf1)
        self.dfs(root2, leaf2)
        if leaf1 == leaf2:
            return True
        return False

    def dfs(self, node, leavels):
        if not node:
            return
        if not node.left and not node.right:
            leavels.append(node.val)
        self.dfs(node.left, leavels)
        self.dfs(node.right, leavels)
