/*
 * Problem: 709. To Lower Case
 * 
 * Description:
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
 * 
 * Requirements:
 * - Convert all uppercase letters to lowercase
 * - Leave other characters unchanged
 * - Return the modified string
 * 
 * Example:
 * Input: s = "Hello"
 * Output: "hello"
 * 
 * Constraints:
 * - 1 <= s.length <= 100
 * - s consists of printable ASCII characters
 */

class Solution {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    /*public String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
    }*/
}
