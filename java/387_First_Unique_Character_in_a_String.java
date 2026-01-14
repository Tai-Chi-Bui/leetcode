/*
 * Problem: 387. First Unique Character in a String
 * 
 * Description:
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 * 
 * Requirements:
 * - Find the first non-repeating character
 * - Return its index
 * - Return -1 if no such character exists
 * 
 * Example:
 * Input: s = "leetcode"
 * Output: 0
 * Explanation: The character 'l' at index 0 is the first character that does not repeat.
 * 
 * Constraints:
 * - 1 <= s.length <= 10^5
 * - s consists of only lowercase English letters
 */

class Solution {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
