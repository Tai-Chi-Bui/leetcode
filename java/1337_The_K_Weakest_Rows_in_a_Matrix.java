/*
 * Problem: 1337. The K Weakest Rows in a Matrix
 * 
 * Description:
 * You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
 * The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left
 * of all the 0's in each row. A row i is weaker than a row j if one of the following is true:
 * - The number of soldiers in row i is less than the number of soldiers in row j
 * - Both rows have the same number of soldiers and i < j
 * Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
 * 
 * Requirements:
 * - Find k weakest rows (rows with fewest soldiers)
 * - If two rows have same number of soldiers, the row with smaller index is weaker
 * - Return indices ordered from weakest to strongest
 * 
 * Example:
 * Input: mat = [[1,1,0,0,0],[1,1,1,1,0],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,1]], k = 3
 * Output: [2,0,3]
 * Explanation: The number of soldiers in each row is: Row 0: 2, Row 1: 4, Row 2: 1, Row 3: 2, Row 4: 5
 * 
 * Constraints:
 * - m == mat.length
 * - n == mat[i].length
 * - 2 <= n, m <= 100
 * - 1 <= k <= m
 * - matrix[i][j] is either 0 or 1
 */

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> res = new ArrayList<>();
        int col = 0;
        boolean flag = true;
        while (col < mat[0].length && flag) {
            for (int i = 0; i < mat.length; i++) {
                if (res.contains(i)) continue;
                // Add first row with 0 into res
                if (mat[i][col] == 0) res.add(i);
                if (res.size() == k) {
                    flag = false;
                    break;
                }
            }
            col += 1;
        }
        if (flag) {
            // if res less than k
            for (int i = 0; i < mat.length; i++) {
                if (res.contains(i)) continue;
                res.add(i);
                if (res.size() == k) break;
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) ret[i] = res.get(i);
        return ret;
    }
}
