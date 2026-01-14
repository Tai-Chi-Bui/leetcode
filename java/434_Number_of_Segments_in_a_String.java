/*
 * Problem: 434. Number of Segments in a String
 * 
 * Description:
 * Given a string s, return the number of segments in the string. A segment is defined to be a
 * contiguous sequence of non-space characters.
 * 
 * Requirements:
 * - Count number of segments (contiguous non-space characters)
 * - Segments are separated by spaces
 * - Return the count
 * 
 * Example:
 * Input: s = "Hello, my name is John"
 * Output: 5
 * Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
 * 
 * Constraints:
 * - 0 <= s.length <= 300
 * - s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:"
 * - The only space character in s is ' '
 */

class Solution {
    // https://leetcode.com/problems/number-of-segments-in-a-string/solution/
    // public int countSegments(String s) {
    //     String trimmed = s.trim();
    //     if (trimmed.equals("")) {
    //         return 0;
    //     }
    //     return trimmed.split("\\s+").length;
    // }
    public int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}