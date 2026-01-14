/*
 * Problem: 55. Jump Game
 * 
 * Description:
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * 
 * Requirements:
 * - Determine if you can reach the last index starting from index 0
 * - Each element represents maximum jump length at that position
 * - Return true if reachable, false otherwise
 * 
 * Example:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^4
 * - 0 <= nums[i] <= 10^5
 */

import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        /*
         * Constraints
         * 1 <= nums.length <= 10^4
         * 0 <= nums[i] <= 10^5
         * 
         * Solution
         * 1. Use BFS Algorithm.
         *   - reason 1 : have to ignore array which is not visited.
         *   - reason 2 : we have to visit all possible array from array[start].
         */

        int N = nums.length;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        
        // First, add first array index.
        // And, set visited[first_index] to true.
        q.add(0);
        visited[0] = true;
        
        // Axiom : if N is 1, result is true.
        if(N == 1) return true;
        
        // BFS algorithm
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            // find cur + 1 to cur + nums[cur]
            for(int i = 1; i <= nums[cur]; i++) {
                if(cur + i >= N - 1) return true;
                int next = Math.min(cur + i, N - 1);
                
                // set visited[next] to true and add index into queue.
                // because of time limit(No overlap steps.)
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        
        return false;
        
    }
}