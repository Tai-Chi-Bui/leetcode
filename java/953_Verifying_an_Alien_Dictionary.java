/*
 * Problem: 953. Verifying an Alien Dictionary
 * 
 * Description:
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters. Given a sequence of words written in the alien language,
 * and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
 * 
 * Requirements:
 * - Check if words are sorted in alien dictionary order
 * - Order is given as permutation of lowercase letters
 * - Return true if sorted, false otherwise
 * 
 * Example:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * 
 * Constraints:
 * - 1 <= words.length <= 100
 * - 1 <= words[i].length <= 20
 * - order.length == 26
 * - All characters in words[i] and order are English lowercase letters
 */

class Solution {
    HashMap<Character, Integer> orderMap = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        // Put value index map into hashmap
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (cmp_alien(words[i], words[i + 1]) > 0) return false; 
        }
        return true;
        
    }
    private int cmp_alien(String a, String b) {
        int ls = a.length() < b.length() ? a.length(): b.length();
        int pos = 0;
        // Compare based on hashmap
        while (pos < ls) {
            if (orderMap.get(a.charAt(pos)) != orderMap.get(b.charAt(pos)))
                return orderMap.get(a.charAt(pos)) - orderMap.get(b.charAt(pos));
            pos += 1;
        }
        return a.length() <= b.length() ? -1: 1;
    }
}
