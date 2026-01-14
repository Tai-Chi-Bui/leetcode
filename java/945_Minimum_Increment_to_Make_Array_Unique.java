/*
 * Problem: 945. Minimum Increment to Make Array Unique
 * 
 * Description:
 * You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
 * Return the minimum number of moves to make every value in nums unique. The test cases are generated so that the answer will fit in a 32-bit integer.
 * 
 * Requirements:
 * - Make all values unique by incrementing
 * - Find minimum number of increments
 * - Return minimum moves
 * 
 * Example:
 * Input: nums = [1,2,2]
 * Output: 1
 * Explanation: After 1 move, the array could be [1, 2, 3].
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - 0 <= nums[i] <= 10^5
 */

class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) return 0;
        HashSet<Integer> numSet = new HashSet<>();
        List<Integer> duplicated = new ArrayList<>();
        int res = 0;
        Arrays.sort(A);
        int left  = A[0];
        int right = A[A.length - 1];
        int holes = right - left + 1;
        for (int v: A) {
            if (numSet.contains(v)) duplicated.add(v);
            else numSet.add(v);
        }
        holes -= numSet.size();
        for (int i = left + 1; i < right; i++) {
            if (holes == 0 || duplicated.size() == 0) break;
            if (!numSet.contains(i) && i > duplicated.get(0)) {
                res += i - duplicated.get(0);
                holes --;
                duplicated.remove(0);
            }
        }
        if (duplicated.size() == 0) return res;
        while (duplicated.size() != 0) {
            right += 1;
            res += right - duplicated.get(0);
            duplicated.remove(0);
        } 
        return res;
    }
}
