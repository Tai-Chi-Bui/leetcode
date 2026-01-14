/*
 * Problem: 836. Rectangle Overlap
 * 
 * Description:
 * An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner,
 * and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis, and its left and right
 * edges are parallel to the Y-axis. Two rectangles overlap if the area of their intersection is positive. To be clear, two rectangles
 * that only touch at the corner or edges do not overlap. Given two axis-aligned rectangles rec1 and rec2, return true if they overlap,
 * otherwise return false.
 * 
 * Requirements:
 * - Check if two rectangles overlap
 * - Rectangles are axis-aligned
 * - Touching at edges/corners doesn't count as overlap
 * - Return true if overlap, false otherwise
 * 
 * Example:
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * 
 * Constraints:
 * - rec1.length == 4
 * - rec2.length == 4
 * - -10^9 <= rec1[i], rec2[i] <= 10^9
 * - rec1 and rec2 represent a valid rectangle with a non-zero area
 */

class Solution {
    /*public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Check position
        return !(rec1[2] <= rec2[0] ||   // left
                 rec1[3] <= rec2[1] ||   // bottom
                 rec1[0] >= rec2[2] ||   // right
                 rec1[1] >= rec2[3]);    // top
    }*/
    /*public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Check area
        // https://leetcode.com/problems/rectangle-area/discuss/62149/Just-another-short-way
        int left = Math.max(rec1[0], rec2[0]), right = Math.max(Math.min(rec1[2], rec2[2]), left);
        int bottom = Math.max(rec1[1], rec2[1]), top = Math.max(Math.min(rec1[3], rec2[3]), bottom);
        return (right - left) * (top - bottom) != 0;
    }*/

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Check area
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
    }
}