/*
 * Problem: 409. Longest Palindrome
 * 
 * Description:
 * Given a string s which consists of lowercase or uppercase letters, return the length of the
 * longest palindrome that can be built with those letters. Letters are case sensitive, for example,
 * "Aa" is not considered a palindrome here.
 * 
 * Requirements:
 * - Build longest palindrome from given letters
 * - Letters are case sensitive
 * - Return the length of longest palindrome
 * 
 * Example:
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * Constraints:
 * - 1 <= s.length <= 2000
 * - s consists of lowercase and/or uppercase English letters only
 */

class Solution {
    // https://leetcode.com/problems/longest-palindrome/solution/
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
}