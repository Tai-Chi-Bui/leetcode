/*
 * Problem: 1304. Find N Unique Integers Sum up to Zero
 * 
 * Description:
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 * 
 * Requirements:
 * - Return array of n unique integers
 * - Sum of all integers must equal 0
 * 
 * Example:
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3], [-3,-1,2,-2,4].
 * 
 * Constraints:
 * - 1 <= n <= 1000
 */

public int[] sumZero(int n) {
    int[] res = new int[n];
    // place negative sum(from 1 to n-1) in 0
    for (int i = 1; i < n; i++) {
        res[i] = i;
        res[0] -= i;
    }
    return res;
}
