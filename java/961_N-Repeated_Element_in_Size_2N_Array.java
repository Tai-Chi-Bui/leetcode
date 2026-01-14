/*
 * Problem: 961. N-Repeated Element in Size 2N Array
 * 
 * Description:
 * You are given an integer array nums with the following properties:
 * - nums.length == 2 * n
 * - nums contains n + 1 unique elements
 * - Exactly one element of nums is repeated n times
 * Return the element that is repeated n times.
 * 
 * Requirements:
 * - Find element repeated n times
 * - Array has 2n elements with n+1 unique elements
 * - Return the repeated element
 * 
 * Example:
 * Input: nums = [1,2,3,3]
 * Output: 3
 * 
 * Constraints:
 * - 2 <= n <= 5000
 * - nums.length == 2 * n
 * - 0 <= nums[i] <= 10^4
 * - nums contains n + 1 unique elements and one of them is repeated exactly n times
 */

class Solution {
    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int ans = A[0];
        for (int n: A) {
            int count = hash.getOrDefault(n, 0) + 1;
            hash.put(n, count);
            if (count >= hash.get(ans)) ans = n;
        }
        return ans;
    }
}
