/*
 * Problem: 733. Flood Fill
 * 
 * Description:
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting
 * from the pixel image[sr][sc]. To perform a flood fill, consider the starting pixel, plus any pixels connected
 * 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected
 * 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the
 * aforementioned pixels with color. Return the modified image after performing the flood fill.
 * 
 * Requirements:
 * - Perform flood fill starting from (sr, sc)
 * - Fill all connected pixels of same color
 * - Connected means 4-directionally adjacent
 * - Return modified image
 * 
 * Example:
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1), all pixels connected by a path of the same color as the starting pixel are colored with the new color.
 * 
 * Constraints:
 * - m == image.length
 * - n == image[i].length
 * - 1 <= m, n <= 50
 * - 0 <= image[i][j], color < 2^16
 * - 0 <= sr < m
 * - 0 <= sc < n
 */

class Solution {
    /*public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int newColor) {
        // Recursively DFS
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r - 1 >= 0) dfs(image, r - 1, c, color, newColor);
            if (r + 1 < image.length) dfs(image, r + 1, c, color, newColor);
            if (c - 1 >= 0) dfs(image, r, c - 1, color, newColor);
            if (c + 1 < image[0].length) dfs(image, r, c + 1, color, newColor);
        }
    }*/

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Node> queue = new LinkedList<Node>();
        int color = image[sr][sc];
        if (color == newColor) return image;
        queue.add(new Node(sr, sc));
        // BFS with queue
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            int r = curr.r, c = curr.c;
            if (image[r][c] == color) {
                image[r][c] = newColor;
                if (r - 1 >= 0) queue.add(new Node(r - 1, c));
                if (r + 1 < image.length) queue.add(new Node(r + 1, c));
                if (c - 1 >= 0) queue.add(new Node(r, c - 1));
                if (c + 1 < image[0].length) queue.add(new Node(r, c + 1));
            }
        }
        return image;
    }

    class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
