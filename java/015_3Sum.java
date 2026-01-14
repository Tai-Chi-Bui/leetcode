/*
 * Problem: 15. 3Sum
 * 
 * Description:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Requirements:
 * - Find all unique triplets that sum to zero
 * - No duplicate triplets in the result
 * - Return list of lists containing the triplets
 * 
 * Example:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: 
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * 
 * Constraints:
 * - 3 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 */

//015. 3Sum
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //create result list to store i,j,k
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        
        //sorting nums
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            if (i > 0 && nums[i] == nums[i-1]) {
                continue; //if nums have same numbers, just check one time.
            } 
            
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                
                if (sum == 0) {
                    //if sum == 0, store i,j,k
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; //check anoter case
                    right--;
                    //if next number == now number
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                    while (nums[right] == nums[right + 1] && left < right) {
                        right--;
                    } 
                } else if (sum > 0) {
                    //if sum > 0, right--;
                    right--;
                } else {
                    //if sum < 0, left++;
                    left++;
                }
            }
        }
        
        return result; //return result list
    }
}
 
