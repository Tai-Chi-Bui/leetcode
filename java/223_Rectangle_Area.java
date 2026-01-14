/*
 * Problem: 223. Rectangle Area
 * 
 * Description:
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area
 * covered by the two rectangles. The first rectangle is defined by its bottom-left corner (ax1, ay1)
 * and its top-right corner (ax2, ay2). The second rectangle is defined by its bottom-left corner
 * (bx1, by1) and its top-right corner (bx2, by2).
 * 
 * Requirements:
 * - Calculate total area covered by two rectangles
 * - Handle overlapping rectangles correctly
 * - Return the total area
 * 
 * Example:
 * Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * Output: 45
 * 
 * Constraints:
 * - -10^4 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10^4
 */

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // https://leetcode.com/problems/rectangle-area/discuss/62149/Just-another-short-way
        // Possible overlap area
        int left = Math.max(A, E), right = Math.max(Math.min(C, G), left);
        int bottom = Math.max(B, F), top = Math.max(Math.min(D, H), bottom);
        return (C - A) * (D - B) - (right - left) * (top - bottom) + (G - E) * (H - F);
    }
}
