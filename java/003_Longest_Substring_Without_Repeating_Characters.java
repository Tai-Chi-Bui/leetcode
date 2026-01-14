/*
 * Problem: 3. Longest Substring Without Repeating Characters
 * 
 * Description:
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Requirements:
 * - Find the longest substring with all unique characters
 * - Return the length of such substring
 * 
 * Example:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces
 */

public class Solution {
    // example in leetcode book
    // public int lengthOfLongestSubstring(String s) {
    // 	boolean[] exist = new boolean[256];
    // 	int i = 0, maxLen = 0;
    // 	for (int j = 0; j < s.length(); j++) {
    // 		while (exist[s.charAt(j)]){
    // 			exist[s.charAt(i)] = false;
    // 			i++;
    // 		}
    // 		exist[s.charAt(j)] = true;
    // 		maxLen = Math.max(j - i + 1, maxLen);
    // 	}
    // 	return maxLen; 
    // }

    public int lengthOfLongestSubstring(String s) {
    	int[] charMap = new int[256];
    	Arrays.fill(charMap, -1);
    	int i = 0, maxLen = 0;
    	for (int j = 0; j < s.length(); j++) {
    		if (charMap[s.charAt(j)] >= i) {
    			i = charMap[s.charAt(j)] + 1;
    		}
    		charMap[s.charAt(j)] = j;
    		maxLen = Math.max(j - i + 1, maxLen);
    	}
    	return maxLen;
    }
}
