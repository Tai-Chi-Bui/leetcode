/*
 * Problem: 538. Convert BST to Greater Tree
 * 
 * Description:
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original
 * BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 * - The left subtree of a node contains only nodes with keys less than the node's key
 * - The right subtree of a node contains only nodes with keys greater than the node's key
 * - Both the left and right subtrees must also be binary search trees
 * 
 * Requirements:
 * - Convert BST to Greater Tree
 * - Each node's value becomes original value + sum of all greater values
 * - Modify tree in-place
 * 
 * Example:
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 10^4]
 * - -10^4 <= Node.val <= 10^4
 * - All the values in the tree are unique
 * - root is guaranteed to be a valid binary search tree
 */

class Solution {
    // https://leetcode.com/problems/convert-bst-to-greater-tree/solution/
    // private int sum = 0;

    // public TreeNode convertBST(TreeNode root) {
    //     if (root != null) {
    //         convertBST(root.right);
    //         sum += root.val;
    //         root.val = sum;
    //         convertBST(root.left);
    //     }
    //     return root;
    // }
    
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }

        return root;
    }
}
