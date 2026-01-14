/*
 * Problem: 560. Subarray Sum Equals K
 * 
 * Description:
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * Requirements:
 * - Find total number of subarrays with sum equal to k
 * - Subarray is contiguous sequence
 * - Return the count
 * 
 * Example:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Explanation: The subarrays [1,1] and [1,1] (from indices 0-1 and 1-2) have sum 2
 * 
 * Constraints:
 * - 1 <= nums.length <= 2 * 10^4
 * - -1000 <= nums[i] <= 1000
 * - -10^7 <= k <= 10^7
 */

public class Solution {
    /*public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }*/
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // check if sum - k in hash
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            // push sum into hash
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
