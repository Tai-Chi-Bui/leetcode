/*
 * Problem: 1365. How Many Numbers Are Smaller Than the Current Number
 * 
 * Description:
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * Return the answer in an array.
 * 
 * Requirements:
 * - For each element, count how many numbers are smaller than it
 * - Return array with counts for each element
 * 
 * Example:
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation: For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * 
 * Constraints:
 * - 2 <= nums.length <= 500
 * - 0 <= nums[i] <= 100
 */

import java.util.Map;

class Solution {
/*     public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> sortedIndex = new HashMap<>();
        int[] sortedNums = new int[nums.length];
        // sort and get position
        System.arraycopy(nums, 0, sortedNums, 0, nums.length);
        Arrays.sort(sortedNums);
        for (int i = 0; i < nums.length; i++) {
            if (sortedIndex.containsKey(sortedNums[i])) continue;
            sortedIndex.put(sortedNums[i], i);
        }
        for (int i = 0; i < nums.length; i++)
            sortedNums[i] = sortedIndex.get(nums[i]);
        return sortedNums;
    } */

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] countList = new int[101];
        int[] res = new int[nums.length];
        // count numbers
        for (int i = 0; i < nums.length; i++)
            countList[nums[i]]++;
        // compute numbers before current index
        for (int i = 1; i < 101; i++)
            countList[i] += countList[i-1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) res[i] = 0;
            else res[i] = countList[nums[i]-1];
        }
        return res;
    }
}
