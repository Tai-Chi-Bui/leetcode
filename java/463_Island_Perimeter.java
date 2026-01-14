/*
 * Problem: 463. Island Perimeter
 * 
 * Description:
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes",
 * meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * 
 * Requirements:
 * - Calculate perimeter of the island
 * - Island consists of connected land cells (1)
 * - Perimeter is sum of edges not shared with other land cells
 * 
 * Example:
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 * 
 * Constraints:
 * - row == grid.length
 * - col == grid[i].length
 * - 1 <= row, col <= 100
 * - grid[i][j] is 0 or 1
 * - There is exactly one island in grid
 */

class Solution {
    public int islandPerimeter(int[][] grid) {
        // https://leetcode.com/problems/island-perimeter/discuss/95001/clear-and-easy-java-solution
        int islands = 0, neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }
}
