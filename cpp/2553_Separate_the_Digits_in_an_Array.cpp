/*
 * Problem: 2553. Separate the Digits in an Array
 * 
 * Description:
 * Given an array of positive integers nums, return an array answer that consists of the digits
 * of each integer in nums after separating them in the same order they appear in nums.
 * 
 * Requirements:
 * - Separate each number into its individual digits
 * - Maintain the order of numbers and digits within each number
 * - Return a single array containing all digits
 * 
 * Example:
 * Input: nums = [13,25,83,77]
 * Output: [1,3,2,5,8,3,7,7]
 * Explanation: 
 * - The separation of 13 is [1,3]
 * - The separation of 25 is [2,5]
 * - The separation of 83 is [8,3]
 * - The separation of 77 is [7,7]
 * answer = [1,3,2,5,8,3,7,7]. Note that answer contains the digits in the same order they appeared in nums.
 * 
 * Constraints:
 * - 1 <= nums.length <= 1000
 * - 1 <= nums[i] <= 10^5
 */

class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        vector<int> answer;
        int n;
        for( int i=0; i < nums.size(); i++){
            n=nums[i];
            vector<int> temp;
            while( n>0 ){
                temp.push_back(n%10);
                n = n / 10;
            }
            for(int j= temp.size()-1; j>=0; j--){
                answer.push_back(temp[j]);
            }
        }
        return answer;
    }
};
