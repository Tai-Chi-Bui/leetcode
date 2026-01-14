/*
 * Problem: 453. Minimum Moves to Equal Array Elements
 * 
 * Description:
 * Given an integer array nums of size n, return the minimum number of moves required to make all
 * array elements equal. In one move, you can increment n - 1 elements of the array by 1.
 * 
 * Requirements:
 * - Make all elements equal with minimum moves
 * - In one move, increment n-1 elements by 1
 * - Return minimum number of moves
 * 
 * Example:
 * Input: nums = [1,2,3]
 * Output: 3
 * Explanation: Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 
 * Constraints:
 * - n == nums.length
 * - 1 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 */

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int min_num = nums[0];
        int ans = 0;
        for (int num : nums) {
            ans += num - min_num;
        }
        return ans;
    }
}