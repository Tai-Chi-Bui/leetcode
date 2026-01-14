/*
 * Problem: 954. Array of Doubled Pairs
 * 
 * Description:
 * Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i]
 * for every 0 <= i < len(arr) / 2, or false otherwise.
 * 
 * Requirements:
 * - Check if array can be reordered so arr[2*i+1] = 2*arr[2*i]
 * - Return true if possible, false otherwise
 * 
 * Example:
 * Input: arr = [3,1,3,6]
 * Output: false
 * 
 * Input: arr = [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 * 
 * Constraints:
 * - 2 <= arr.length <= 3 * 10^4
 * - arr.length is even
 * - -10^5 <= arr[i] <= 10^5
 */

class Solution {
    public boolean canReorderDoubled(int[] A) {
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        // Sort in[] with comparator
        A = Arrays.stream(A).
                boxed().
                sorted((a, b) -> Integer.compare(Math.abs(a), Math.abs(b))).
                mapToInt(i -> i).
                toArray();
        for (int n: A) valueMap.put(n, valueMap.getOrDefault(n, 0) + 1);
        for (int n: A) {
            if (valueMap.get(n) <= 0) continue;
            if (valueMap.containsKey(2 * n) && valueMap.get(2 * n) > 0) {
                valueMap.put(n, valueMap.get(n) - 1);
                valueMap.put(2 * n, valueMap.get(2 * n) - 1);
            } else {
                return false;
            }
        }
        return true;
    }


}
