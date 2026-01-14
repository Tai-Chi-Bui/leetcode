/*
 * Problem: 819. Most Common Word
 * 
 * Description:
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned.
 * It is guaranteed there is at least one word that is not banned, and that the answer is unique. The words in paragraph are
 * case-insensitive and the answer should be returned in lowercase.
 * 
 * Requirements:
 * - Find most frequent word not in banned list
 * - Words are case-insensitive
 * - Return word in lowercase
 * - Ignore punctuation
 * 
 * Example:
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * Output: "ball"
 * Explanation: "hit" occurs 3 times, but it is a banned word. "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * 
 * Constraints:
 * - 1 <= paragraph.length <= 1000
 * - paragraph consists of English letters, space ' ', or one of the symbols: "!?',;."
 * - 0 <= banned.length <= 100
 * - 1 <= banned[i].length <= 10
 * - banned[i] consists of lowercase English letters
 */

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                // word
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                // punctuation symbols
                // node that word length should be larger than 0
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    // Record max here
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }
        return ans;
    }
}
