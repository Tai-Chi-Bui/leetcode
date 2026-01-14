/*
 * Problem: 671. Second Minimum Node In a Binary Tree
 * 
 * Description:
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node
 * in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is
 * the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val)
 * always holds. Given such a binary tree, you need to output the second minimum value in the set made of
 * all the nodes' value in the whole tree. If no such second minimum value exists, output -1 instead.
 * 
 * Requirements:
 * - Find second minimum value in the tree
 * - Root value is minimum of its children
 * - Return -1 if second minimum doesn't exist
 * 
 * Example:
 * Input: root = [2,2,5,null,null,5,7]
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * 
 * Constraints:
 * - The number of nodes in the tree is in the range [1, 25]
 * - 1 <= Node.val <= 2^31 - 1
 * - root.val == min(root.left.val, root.right.val) for each internal node of the tree
 */

class Solution {
    /*public void dfs(TreeNode root, Set<Integer> uniques) {
        if (root != null) {
            uniques.add(root.val);
            dfs(root.left, uniques);
            dfs(root.right, uniques);
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        // Brute force
        Set<Integer> uniques = new HashSet<Integer>();
        dfs(root, uniques);

        int min1 = root.val;
        long ans = Long.MAX_VALUE;
        for (int v : uniques) {
            if (min1 < v && v < ans) ans = v;
        }
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }*/

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int min_val = root.val;
        int ans = Integer.MAX_VALUE;
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            if (node.val < ans && node.val > min_val) {
                ans = node.val;
            } else if (node.val == min_val) {
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}
