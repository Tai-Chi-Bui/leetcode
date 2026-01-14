/*
 * Problem: 1248. Count Number of Nice Subarrays
 * 
 * Description:
 * Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.
 * Return the number of nice sub-arrays.
 * 
 * Requirements:
 * - A subarray is a contiguous part of an array
 * - A nice subarray contains exactly k odd numbers
 * - Return the total count of nice subarrays
 * 
 * Example:
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * 
 * Constraints:
 * - 1 <= nums.length <= 50000
 * - 1 <= nums[i] <= 10^5
 * - 1 <= k <= nums.length
 */

class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

private:
    int atMostK(const vector<int>& nums, int k) {
        int result = 0, left = 0, count = 0;
        for (int right = 0; right < nums.size(); ++right) {
            count += nums[right] % 2;
            while (count > k) {
                count -= nums[left] % 2;
                ++left;
            }
            result += right - left + 1;
        }
        return result;
    }
};

// Time:  O(n)
// Space: O(k)
class Solution2 {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        int result = 0;
        deque<int> dq = {-1};
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] % 2) {
                dq.emplace_back(i);
            }
            if (dq.size() > k + 1) {
                dq.pop_front();
            }
            if (dq.size() == k + 1) {
                result += dq[1] - dq[0];
            }
        }
        return result;
    }
};
