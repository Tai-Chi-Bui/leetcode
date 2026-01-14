/*
 * Problem: 700. Search in a Binary Search Tree
 * 
 * Description:
 * You are given the root of a binary search tree (BST) and an integer val. Find the node in the BST
 * that the node's value equals val and return the subtree rooted with that node. If such a node does
 * not exist, return null.
 * 
 * Requirements:
 * - Search for node with value val in BST
 * - Return subtree rooted at that node
 * - Return null if node not found
 * 
 * Example:
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * 
 * Constraints:
 * - The number of nodes in the tree is in the range [1, 5000]
 * - 1 <= Node.val <= 10^7
 * - root is a valid binary search tree
 * - 1 <= val <= 10^7
 */

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
    /*public TreeNode searchBST(TreeNode root, int val) {
        // Recursive
        if (root == null) return root;
        if (root.val == val) return root;
        else return val<root.val? searchBST(root.left,val):searchBST(root.right,val);
    }*/
    public TreeNode searchBST(TreeNode root, int val) {
        // Iteration
        while(root != null && root.val != val) {
            root = val < root.val ? root.left: root.right;
        }
        return root;
    }
}
