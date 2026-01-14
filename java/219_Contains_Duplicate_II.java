/*
 * Problem: 219. Contains Duplicate II
 * 
 * Description:
 * Given an integer array nums and an integer k, return true if there are two distinct indices
 * i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * 
 * Requirements:
 * - Check if there are two duplicate values within distance k
 * - Return true if such pair exists, false otherwise
 * 
 * Example:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 * - 0 <= k <= 10^5
 */

import java.util.*;

class Solution {
  /*
   * I have to save indice for each index.
   * So I use the HashMap<Integer, List<Integer>>
   */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        
		// use Iterator to find appropriate two indice.
		// Each list guarantee ascending.
		// So list.get(i) and list.get(i + 1) is minimum.
        Iterator<Integer> keys = map.keySet().iterator();
        boolean answer = false;
        
        while(keys.hasNext()) {
            int key = keys.next();
            List<Integer> list = map.get(key);
            
            if(list.size() < 2) continue;
            
            for(int i = 1; i < list.size(); i++) {
                int a = list.get(i - 1);
                int b = list.get(i);
                
                if(b - a <= k) {
                    answer = true;
                    break;
                }
            }
            if(answer) break;
        }
        return answer;
    }
}
