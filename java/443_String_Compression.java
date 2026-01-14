/*
 * Problem: 443. String Compression
 * 
 * Description:
 * Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * - If the group's length is 1, append the character to s
 * - Otherwise, append the character followed by the group's length
 * The compressed string s should not be returned separately, but instead be stored in the input
 * character array chars. Note that group lengths that are 10 or longer will be split into multiple
 * characters in chars. After you are done modifying the input array, return the new length of the array.
 * 
 * Requirements:
 * - Compress array in-place
 * - Replace consecutive characters with character + count
 * - Return new length of compressed array
 * 
 * Example:
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * 
 * Constraints:
 * - 1 <= chars.length <= 2000
 * - chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol
 */

class Solution {
    public int compress(char[] chars) {
        // https://leetcode.com/problems/string-compression/solution/
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
}