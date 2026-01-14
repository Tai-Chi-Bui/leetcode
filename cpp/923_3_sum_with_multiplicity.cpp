/*
 * Problem: 923. 3Sum With Multiplicity
 * 
 * Description:
 * Given an integer array arr, and an integer target, return the number of tuples i, j, k
 * such that i < j < k and arr[i] + arr[j] + arr[k] == target.
 * As the answer can be very large, return it modulo 10^9 + 7.
 * 
 * Requirements:
 * - Find all triplets (i, j, k) where i < j < k
 * - Sum of arr[i] + arr[j] + arr[k] equals target
 * - Count all such triplets (duplicates allowed)
 * - Return count modulo 10^9 + 7
 * 
 * Example:
 * Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
 * Output: 20
 * Explanation: 
 * Enumerating by the values (arr[i], arr[j], arr[k]):
 * (1, 2, 5) occurs 8 times;
 * (1, 3, 4) occurs 8 times;
 * (2, 2, 4) occurs 2 times;
 * (2, 3, 3) occurs 2 times.
 * 
 * Constraints:
 * - 3 <= arr.length <= 3000
 * - 0 <= arr[i] <= 100
 * - 0 <= target <= 300
 */

class Solution {
public:
    int threeSumMulti(vector<int>& A, int target) {
        unordered_map<int, uint64_t> count;
        for (const auto& a : A) {
            ++count[a];
        }
        uint64_t result = 0;
        for (const auto& kvp1 : count) {
            for (const auto& kvp2 : count) {
                int i = kvp1.first, j = kvp2.first, k = target - i - j;
                if (!count.count(k)) {
                    continue;
                }
                if (i == j && j == k) {
                    result += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                } else if (i == j && j != k) {
                    result += count[i] * (count[i] - 1) / 2 * count[k];
                } else if (i < j && j < k) {
                    result += count[i] * count[j] * count[k];
                }
            }
        }
        return result % static_cast<int>(1e9 + 7);
    }
};
