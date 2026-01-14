/*
 * Problem: 617. Merge Two Binary Trees
 * 
 * Description:
 * You are given two binary trees root1 and root2. Imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into
 * a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value
 * of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 * Return the merged tree.
 * 
 * Requirements:
 * - Merge two binary trees
 * - If nodes overlap, sum their values
 * - If one node is null, use the other node
 * - Return the merged tree
 * 
 * Example:
 * Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * Output: [3,4,5,5,4,null,7]
 * 
 * Constraints:
 * - The number of nodes in both trees is in the range [0, 2000]
 * - -10^4 <= Node.val <= 10^4
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
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    // public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    //     if (t1 == null)
    //         return t2;
    //     Stack < TreeNode[] > stack = new Stack < > ();
    //     stack.push(new TreeNode[] {t1, t2});
    //     while (!stack.isEmpty()) {
    //         TreeNode[] t = stack.pop();
    //         if (t[0] == null || t[1] == null) {
    //             continue;
    //         }
    //         t[0].val += t[1].val;
    //         if (t[0].left == null) {
    //             t[0].left = t[1].left;
    //         } else {
    //             stack.push(new TreeNode[] {t[0].left, t[1].left});
    //         }
    //         if (t[0].right == null) {
    //             t[0].right = t[1].right;
    //         } else {
    //             stack.push(new TreeNode[] {t[0].right, t[1].right});
    //         }
    //     }
    //     return t1;
    // }
}
