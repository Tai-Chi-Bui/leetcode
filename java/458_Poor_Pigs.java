/*
 * Problem: 458. Poor Pigs
 * 
 * Description:
 * There are buckets buckets of liquid, where exactly one of the buckets is poisonous. To figure out
 * which one is poisonous, you feed some number of (poor) pigs the liquid to see whether they will
 * die or not. Unfortunately, you only have minutesToTest minutes to determine which bucket is poisonous.
 * You can feed the pigs according to these steps:
 * 1. Choose some live pigs to feed them
 * 2. For each pig, choose which buckets to feed it. The pig will consume all the chosen buckets simultaneously
 * 3. Wait for minutesToDie. You may not feed any other pigs during this time
 * 4. After minutesToDie minutes have passed, any pigs that have been fed the poisonous bucket will die
 * 5. Repeat the process until you run out of time
 * 
 * Requirements:
 * - Find minimum number of pigs needed to identify the poisonous bucket
 * - Pigs can be fed multiple times
 * - Return minimum number of pigs
 * 
 * Example:
 * Input: buckets = 1000, minutesToDie = 15, minutesToTest = 60
 * Output: 5
 * 
 * Constraints:
 * - 1 <= buckets <= 1000
 * - 1 <= minutesToDie <= minutesToTest <= 100
 */

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        while (Math.pow(n, pigs) < buckets) pigs++;
        return pigs; 
    }
}
