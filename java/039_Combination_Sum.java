/*
 * Problem: 39. Combination Sum
 * 
 * Description:
 * Given an array of distinct integers candidates and a target integer target, return a list
 * of all unique combinations of candidates where the chosen numbers sum to target. You may
 * return the combinations in any order. The same number may be chosen from candidates an
 * unlimited number of times.
 * 
 * Requirements:
 * - Find all unique combinations that sum to target
 * - Same number can be used multiple times
 * - Return list of lists containing the combinations
 * 
 * Example:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation: 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 
 * Constraints:
 * - 1 <= candidates.length <= 30
 * - 2 <= candidates[i] <= 40
 * - All elements of candidates are distinct
 * - 1 <= target <= 500
 */

//039_Combination_Sum
class Solution {
    List<List<Integer>> answer = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int clen =candidates.length;
        for (int i = 0; i < clen; i++) {
            List<Integer> tlist = new ArrayList<Integer>();
            tlist.add(candidates[i]);
            backtracking(candidates, i, 1, (target - candidates[i]), tlist);
        }
        return answer;
    }
    private void backtracking(int[] candidates, int index, int tsize, int target, List<Integer> temp) {
        if (target == 0) {
            answer.add(new ArrayList(temp));
            return;
        }
        
        for (int i = index, len = candidates.length; i < len; i++) {
            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                backtracking(candidates, i, (tsize + 1), (target - candidates[i]), temp);
                temp.remove(tsize);
            }
        }
    }
}

