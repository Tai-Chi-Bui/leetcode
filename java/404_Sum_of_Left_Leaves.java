/*
 * Problem: 404. Sum of Left Leaves
 * 
 * Description:
 * Given the root of a binary tree, return the sum of all left leaves.
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 * 
 * Requirements:
 * - Find sum of all left leaves
 * - A left leaf is a leaf node that is the left child of its parent
 * - Return the sum
 * 
 * Example:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
 * 
 * Constraints:
 * - The number of nodes in the tree is in the range [1, 1000]
 * - -1000 <= Node.val <= 1000
 */

import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /* public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null
            && root.left.left == null
            && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    } */

    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.left != null
                    && node.left.left == null
                    && node.left.right == null)
                    res += node.left.val;
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return res;
    }
}
