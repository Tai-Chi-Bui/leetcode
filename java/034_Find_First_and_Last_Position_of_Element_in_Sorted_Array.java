/*
 * Problem: 34. Find First and Last Position of Element in Sorted Array
 * 
 * Description:
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
 * position of a given target value. If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Requirements:
 * - Find first and last position of target in sorted array
 * - Return [-1, -1] if target not found
 * - Time complexity must be O(log n)
 * 
 * Example:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Constraints:
 * - 0 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 * - nums is a non-decreasing array
 * - -10^9 <= target <= 10^9
 */

class Solution {
    /*
        Rule 1
        - Given array is sorted in non-decreasing order
        
        Rule 2
        - Limit time complexity O(log n).
        
        So I can use Binary Search Algorithm.
    */
    public int[] searchRange(int[] nums, int target) {
        // initialize arr[0] -> maximum integer, arr[1] -> minimum integer
        int[] arr = {100001, -10};
        int s = 0;
        int e = nums.length - 1;
        
        // find minimum index in nums with Binary Search alogorithm
        while (s <= e) {
            
            int mid = (s + e) / 2;
            
            if(nums[mid] > target) {
                e = mid - 1;
            }
            else if(nums[mid] <= target) {
                if(nums[mid] == target) {
                    arr[0] = Math.min(arr[0], mid);
                    arr[1] = Math.max(arr[1], mid);
                }
                s = mid + 1;
            }
        }
        
        s = 0;
        e = nums.length - 1;
        
        // find maximum index in nums with Binary Search alogorithm
        while(s <= e) {
            int mid = (s + e) / 2;
            
            if(nums[mid] >= target) {
                if(nums[mid] == target) {
                    arr[0] = Math.min(arr[0], mid);
                    arr[1] = Math.max(arr[1], mid);
                }
                e = mid - 1;
            }
            else if(nums[mid] < target) {
                s = mid + 1;
            }
        }
        
        // if arr data is initial data, set -1.
        if(arr[0] == 100001) arr[0] = -1;
        if(arr[1] == -10) arr[1] = -1;
        
        return arr;
    }
}
