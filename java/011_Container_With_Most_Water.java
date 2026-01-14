/*
 * Problem: 11. Container With Most Water
 * 
 * Description:
 * You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains
 * the most water.
 * Return the maximum amount of water a container can store.
 * 
 * Requirements:
 * - Find two lines that form a container with maximum area
 * - Area = min(height[i], height[j]) * (j - i)
 * - Return the maximum area
 * 
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * 
 * Constraints:
 * - n == height.length
 * - 2 <= n <= 10^5
 * - 0 <= height[i] <= 10^4
 */

class Solution {
  public int maxArea(int[] height) {

    int maxArea = 0;
    int left = 0;
    int right = height.length - 1;

    while (left < right) {
      maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
      // Two points
      if (height[left] < height[right]) left++;
      else right--;
    }
    return maxArea;
  }
}
