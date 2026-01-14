/*
 * Problem: 541. Reverse String II
 * 
 * Description:
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start
 * of the string. If there are fewer than k characters left, reverse all of them. If there are less than 2k but
 * greater than or equal to k characters, then reverse the first k characters and leave the other as original.
 * 
 * Requirements:
 * - Reverse first k characters for every 2k characters
 * - If fewer than k characters left, reverse all of them
 * - Return the modified string
 * 
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Explanation: For every 2k characters, reverse first k: "ab" -> "ba", "cd" stays, "ef" -> "fe", "g" stays
 * 
 * Constraints:
 * - 1 <= s.length <= 10^4
 * - s consists of only lowercase English letters
 * - 1 <= k <= 10^4
 */

class Solution {
    public String reverseStr(String s, int k) {
        // https://leetcode.com/problems/reverse-string-ii/solution/
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            // Reverse from i to j
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
