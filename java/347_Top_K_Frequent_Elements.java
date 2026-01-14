/*
 * Problem: 347. Top K Frequent Elements
 * 
 * Description:
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * 
 * Requirements:
 * - Find k most frequent elements
 * - Return in any order
 * - Handle ties appropriately
 * 
 * Example:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 * - k is in the range [1, the number of unique elements in the array]
 * - It is guaranteed that the answer is unique
 */

class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    // build hash map : character and how often it appears
    HashMap<Integer, Integer> count = new HashMap();
    for (int n: nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }

    // init heap 'the less frequent element first'
    PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

    // keep k top frequent elements in the heap
    for (int n: count.keySet()) {
      heap.add(n);
      if (heap.size() > k)
        heap.poll();
    }

    // build output list
    List<Integer> top_k = new LinkedList();
    while (!heap.isEmpty())
      top_k.add(heap.poll());
    Collections.reverse(top_k);
    return top_k;
  }
}
