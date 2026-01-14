/*
 * Problem: 383. Ransom Note
 * 
 * Description:
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by
 * using the letters from magazine and false otherwise. Each letter in magazine can only be used once in ransomNote.
 * 
 * Requirements:
 * - Check if ransomNote can be constructed from magazine
 * - Each letter in magazine can be used only once
 * - Return true if possible, false otherwise
 * 
 * Example:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * 
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * 
 * Constraints:
 * - 1 <= ransomNote.length, magazine.length <= 10^5
 * - ransomNote and magazine consist of lowercase English letters
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[128];
        for (char c : magazine.toCharArray()) table[c]++;
        for (char c : ransomNote.toCharArray())
            if (--table[c] < 0) return false;
        return true;
    }
}
