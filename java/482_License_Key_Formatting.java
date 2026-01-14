/*
 * Problem: 482. License Key Formatting
 * 
 * Description:
 * You are given a license key represented as a string s that consists of only alphanumeric characters and dashes.
 * The string is separated into n + 1 groups by n dashes. You are also given an integer k.
 * We want to reformat the string s such that each group contains exactly k characters, except for the first group,
 * which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash
 * inserted between two groups, and you should convert all lowercase letters to uppercase.
 * Return the reformatted license key.
 * 
 * Requirements:
 * - Reformat license key with groups of k characters
 * - First group can be shorter but at least 1 character
 * - Convert to uppercase
 * - Insert dashes between groups
 * 
 * Example:
 * Input: s = "5F3Z-2e-9-w", k = 4
 * Output: "5F3Z-2E9W"
 * Explanation: The string s has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 * 
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s consists of English letters, digits, and dashes '-'
 * - 1 <= k <= 10^4
 */

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        // https://leetcode.com/problems/license-key-formatting/discuss/96512/Java-5-lines-clean-solution
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    } 
}
