/*
 * Problem: 680. Valid Palindrome II
 * 
 * Description:
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * 
 * Requirements:
 * - Check if string can be palindrome after deleting at most one character
 * - Return true if possible, false otherwise
 * 
 * Example:
 * Input: s = "aba"
 * Output: true
 * 
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * 
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s consists of lowercase English letters
 */

class Solution {
    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                // Not equal
                int j = s.length() - 1 - i;
                // delete left or right
                return (isPalindromeRange(s, i + 1, j) ||
                        isPalindromeRange(s, i, j - 1));
            }
        }
        return true;
    }
}
