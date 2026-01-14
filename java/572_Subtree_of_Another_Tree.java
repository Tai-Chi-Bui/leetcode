/*
 * Problem: 572. Subtree of Another Tree
 * 
 * Description:
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root
 * with the same structure and node values of subRoot and false otherwise. A subtree of a binary tree
 * tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree
 * could also be considered as a subtree of itself.
 * 
 * Requirements:
 * - Check if subRoot is a subtree of root
 * - Subtree must have same structure and node values
 * - Return true if found, false otherwise
 * 
 * Example:
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * 
 * Constraints:
 * - The number of nodes in the root tree is in the range [1, 2000]
 * - The number of nodes in the subRoot tree is in the range [1, 1000]
 * - -10^4 <= root.val <= 10^4
 * - -10^4 <= subRoot.val <= 10^4
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
    // https://leetcode.com/problems/subtree-of-another-tree/solution/
    HashSet < String > trees = new HashSet < > ();
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        return tree1.indexOf(tree2) >= 0;
    }
    public String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
    }

    // public boolean isSubtree(TreeNode s, TreeNode t) {
    //     return traverse(s,t);
    // }
    // public boolean equals(TreeNode x,TreeNode y)
    // {
    //     if(x==null && y==null)
    //         return true;
    //     if(x==null || y==null)
    //         return false;
    //     return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    // }
    // public boolean traverse(TreeNode s,TreeNode t)
    // {
    //     return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    // }
}
