/*
 * Problem: 697. Degree of an Array
 * 
 * Description:
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum
 * frequency of any one of its elements. Your task is to find the smallest possible length of a (contiguous)
 * subarray of nums, that has the same degree as nums.
 * 
 * Requirements:
 * - Find smallest subarray with same degree as array
 * - Degree is maximum frequency of any element
 * - Return length of smallest such subarray
 * 
 * Example:
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation: The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree: [2,2] has length 2, so return 2.
 * 
 * Constraints:
 * - nums.length will be between 1 and 50,000
 * - nums[i] will be an integer between 0 and 49,999
 */

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
            right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            // left most position
            if (left.get(x) == null) left.put(x, i);
            // right most position
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }
}
