/*
 * Problem: 437. Path Sum III
 * 
 * Description:
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum
 * of the values along the path equals targetSum. The path does not need to start or end at the root
 * or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 * 
 * Requirements:
 * - Count paths with sum equal to targetSum
 * - Path can start and end anywhere (not just root to leaf)
 * - Path must go downwards (parent to child)
 * - Return the count
 * 
 * Example:
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * 
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 1000]
 * - -10^9 <= Node.val <= 10^9
 * - -1000 <= targetSum <= 1000
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
    /*public int pathSum(TreeNode root, int sum) {
        if (root != null) return findPaths(root, sum)
            + pathSum(root.left, sum)
            + pathSum(root.right, sum);
        return 0;
    }

    private int findPaths(TreeNode root, int target) {
        if (root != null) return (root.val == target? 1 : 0)
            + findPaths(root.left, target - root.val)
            + findPaths(root.right, target - root.val);
        return 0;
    }*/

    private int result;
    private HashMap<Integer, Integer> cache;

    public int pathSum(TreeNode root, int sum) {
        result = 0;
        cache = new HashMap<Integer, Integer>();
        cache.put(0, 1);
        pathSumHelper(root, sum, 0);
        return result;
    }
    // https://leetcode.com/problems/path-sum-iii/discuss/91892/Python-solution-with-detailed-explanation
    private void pathSumHelper(TreeNode root, int target, int soFar) {
        if (root != null) {
            int complement = soFar + root.val - target;
            if (cache.containsKey(complement))
                result += cache.get(complement);
            cache.put(soFar + root.val, cache.getOrDefault(soFar + root.val, 0) + 1);
            pathSumHelper(root.left, target, soFar + root.val);
            pathSumHelper(root.right, target, soFar + root.val);
            cache.put(soFar + root.val, cache.get(soFar + root.val) - 1);
        }
    }
}
