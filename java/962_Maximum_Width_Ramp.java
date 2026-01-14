/*
 * Problem: 962. Maximum Width Ramp
 * 
 * Description:
 * A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.
 * Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.
 * 
 * Requirements:
 * - Find maximum width ramp
 * - Ramp: i < j and nums[i] <= nums[j]
 * - Width is j - i
 * - Return maximum width, 0 if no ramp
 * 
 * Example:
 * Input: nums = [6,0,8,2,1,5]
 * Output: 4
 * Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.
 * 
 * Constraints:
 * - 2 <= nums.length <= 5 * 10^4
 * - 0 <= nums[i] <= 5 * 10^4
 */

import java.awt.Point;
class Solution {
    public int maxWidthRamp(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i;
        // Sort index based on value
        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans = 0;
        int m = N;
        for (int i: B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }
        return ans;
    }

    /*public int maxWidthRamp(int[] A) {
        int N = A.length;

        int ans = 0;
        List<Point> candidates = new ArrayList();
        candidates.add(new Point(A[N-1], N-1));

        // candidates: i's decreasing, by increasing value of A[i]
        for (int i = N-2; i >= 0; --i) {
            // Find largest j in candidates with A[j] >= A[i]
            int lo = 0, hi = candidates.size();
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (candidates.get(mi).x < A[i])
                    lo = mi + 1;
                else
                    hi = mi;
            }
            if (lo < candidates.size()) {
                int j = candidates.get(lo).y;
                ans = Math.max(ans, j - i);
            } else {
                candidates.add(new Point(A[i], i));
            }
        }
        return ans;
    }*/

}