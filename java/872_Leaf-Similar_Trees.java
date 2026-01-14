/*
 * Problem: 872. Leaf-Similar Trees
 * 
 * Description:
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same. Return true if and only if the two
 * given trees with head nodes root1 and root2 are leaf-similar.
 * 
 * Requirements:
 * - Check if two trees have same leaf value sequence
 * - Leaves are from left to right
 * - Return true if leaf sequences match, false otherwise
 * 
 * Example:
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 * 
 * Constraints:
 * - The number of nodes in each tree will be in the range [1, 200]
 * - Both of the given trees will have values in the range [0, 200]
 */

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null)
                leafValues.add(node.val);
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
}
