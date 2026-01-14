/*
 * Problem: 414. Third Maximum Number
 * 
 * Description:
 * Given an integer array nums, return the third distinct maximum number in this array.
 * If the third maximum does not exist, return the maximum number.
 * 
 * Requirements:
 * - Find the third distinct maximum number
 * - If third maximum doesn't exist, return the maximum
 * - Handle distinct numbers only
 * 
 * Example:
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation: The first distinct maximum is 3, the second is 2, and the third is 1.
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - -2^31 <= nums[i] <= 2^31 - 1
 */

public class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) continue;
            pq.offer(i);
            set.add(i);
            if (pq.size() > 3) set.remove(pq.poll());
        }
        while (pq.size() < 3 && pq.size() > 1) {
            pq.poll();
        }
        return pq.peek();
    }
}
