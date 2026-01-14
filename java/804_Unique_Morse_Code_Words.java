/*
 * Problem: 804. Unique Morse Code Words
 * 
 * Description:
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
 * - 'a' maps to ".-", 'b' maps to "-...", 'c' maps to "-.-.", and so on.
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
 * For example, "cab" can be written as "-.-..--...", which is the concatenation "-.-." + ".-" + "-...". We'll call such a concatenation the transformation of a word.
 * Return the number of different transformations among all words we have.
 * 
 * Requirements:
 * - Convert each word to Morse code
 * - Count number of unique Morse code transformations
 * - Return the count
 * 
 * Example:
 * Input: words = ["gin","zen","gig","msg"]
 * Output: 2
 * Explanation: The transformation of each word is: "gin" -> "--...-.", "zen" -> "--...-.", "gig" -> "--...--.", "msg" -> "--...--."
 * The two different transformations are "--...-." and "--...--.".
 * 
 * Constraints:
 * - 1 <= words.length <= 100
 * - 1 <= words[i].length <= 12
 * - words[i] consists of lowercase English letters
 */

class Solution {
    // https://leetcode.com/problems/unique-morse-code-words/solution/
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.."};

        Set<String> seen = new HashSet();
        for (String word: words) {
            StringBuilder code = new StringBuilder();
            for (char c: word.toCharArray())
                code.append(MORSE[c - 'a']);
            seen.add(code.toString());
        }

        return seen.size();
    }
}
