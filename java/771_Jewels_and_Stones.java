/*
 * Problem: 771. Jewels and Stones
 * 
 * Description:
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
 * Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * 
 * Requirements:
 * - Count how many stones are jewels
 * - Letters are case sensitive
 * - Return the count
 * 
 * Example:
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 * 
 * Constraints:
 * - 1 <= jewels.length, stones.length <= 50
 * - jewels and stones consist of only English letters
 * - All the characters of jewels are unique
 */

import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        HashSet jHash = new HashSet<>();
        for (int j = 0; j < J.length(); j++) {
            jHash.add(J.charAt(j));
        }
        for (int s = 0; s < S.length(); s++) {
            if (jHash.contains(S.charAt(s))) {
                result++;
            }
        }
        return result;
    }
}
