"""
Problem: 733. Flood Fill

Description:
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting
from the pixel image[sr][sc]. To perform a flood fill, consider the starting pixel, plus any pixels connected
4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected
4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the
aforementioned pixels with color. Return the modified image after performing the flood fill.

Requirements:
- Perform flood fill starting from (sr, sc)
- Fill all connected pixels of same color
- Connected means 4-directionally adjacent
- Return modified image

Example:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1), all pixels connected by a path of the same color as the starting pixel are colored with the new color.

Constraints:
- m == image.length
- n == image[i].length
- 1 <= m, n <= 50
- 0 <= image[i][j], color < 2^16
- 0 <= sr < m
- 0 <= sc < n
"""

class Solution(object):
    # def floodFill(self, image, sr, sc, newColor):
    #     """
    #     :type image: List[List[int]]
    #     :type sr: int
    #     :type sc: int
    #     :type newColor: int
    #     :rtype: List[List[int]]
    #     """
    #     r_ls, c_ls = len(image), len(image[0])
    #     color = image[sr][sc]
    #     if color == newColor:
    #         return image

    #     def dfs(r, c):
    #         if image[r][c] == color:
    #             image[r][c] = newColor
    #             if r - 1 >= 0: dfs(r - 1, c)
    #             if r + 1 < r_ls: dfs(r + 1, c)
    #             if c - 1 >= 0: dfs(r, c - 1)
    #             if c + 1 < c_ls: dfs(r, c + 1)

    #     dfs(sr, sc)
    #     return image

    def floodFill(self, image, sr, sc, newColor):
        # BFS with queue
        r_ls, c_ls = len(image), len(image[0])
        color = image[sr][sc]
        if color == newColor:
            return image
        queue = [(sr, sc)]
        while len(queue) > 0:
            r, c = queue.pop(0)
            if image[r][c] == color:
                image[r][c] = newColor
                if r - 1 >= 0: queue.append((r - 1, c))
                if r + 1 < r_ls: queue.append((r + 1, c))
                if c - 1 >= 0: queue.append((r, c - 1))
                if c + 1 < c_ls: queue.append((r, c + 1))
        return image
