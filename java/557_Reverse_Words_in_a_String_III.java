/*
 * Problem: 557. Reverse Words in a String III
 * 
 * Description:
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving
 * whitespace and initial word order.
 * 
 * Requirements:
 * - Reverse characters in each word
 * - Preserve whitespace and word order
 * - Return the modified string
 * 
 * Example:
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * Constraints:
 * - 1 <= s.length <= 5 * 10^4
 * - s contains printable ASCII characters
 * - s does not contain any leading or trailing spaces
 * - There is at least one word in s
 * - All the words in s are separated by a single space
 */

public class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String word: words)
            ans.append(new StringBuffer(word).reverse().toString() + " ");
        return ans.toString().trim();
    }
}
