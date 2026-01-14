/*
 * Problem: 654. Maximum Binary Tree
 * 
 * Description:
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively
 * from nums using the following algorithm:
 * 1. Create a root node whose value is the maximum value in nums
 * 2. Recursively build the left subtree on the subarray prefix to the left of the maximum value
 * 3. Recursively build the right subtree on the subarray suffix to the right of the maximum value
 * Return the maximum binary tree built from nums.
 * 
 * Requirements:
 * - Build maximum binary tree from array
 * - Root is maximum value
 * - Left subtree from left subarray, right subtree from right subarray
 * - Return the constructed tree
 * 
 * Example:
 * Input: nums = [3,2,1,6,0,5]
 * Output: [6,3,5,null,2,0,null,null,1]
 * 
 * Constraints:
 * - 1 <= nums.length <= 1000
 * - 0 <= nums[i] <= 1000
 * - All integers in nums are unique
 */

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = construct(nums, l, max_i);
        root.right = construct(nums, max_i + 1, r);
        return root;
    }
    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }
    /*public TreeNode constructMaximumBinaryTree(int[] nums) {
        // https://leetcode.com/problems/maximum-binary-tree/discuss/106146/C++-O(N)-solution
        Stack<TreeNode> stack = new Stack<>();
        for (int i=0; i<nums.length(); i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while (!stack.empty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if (!stack.empty()) 
                stack.peek().right = curr;
            stack.push(curr);
        }
        while (stack.size() != 1) {
            stack.pop()
        }
        return stack.peek();
    }*/
}
