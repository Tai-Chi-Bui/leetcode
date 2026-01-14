/*
 * Problem: 703. Kth Largest Element in a Stream
 * 
 * Description:
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element
 * in the sorted order, not the kth distinct element. Implement KthLargest class:
 * - KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums
 * - int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream
 * 
 * Requirements:
 * - Design class to find kth largest element in stream
 * - Support adding new elements
 * - Return kth largest after each add operation
 * 
 * Example:
 * Input: ["KthLargest", "add", "add", "add", "add", "add"], [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output: [null, 4, 5, 5, 8, 8]
 * Explanation: KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 * 
 * Constraints:
 * - 1 <= k <= 10^4
 * - 0 <= nums.length <= 10^4
 * - -10^4 <= nums[i] <= 10^4
 * - -10^4 <= val <= 10^4
 * - At most 10^4 calls will be made to add
 */

class KthLargest {

    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        // remove n - k smallest number
        for (int val : nums)
            add(val);
    }

    public int add(int val) {
        // add to heaq if it's less then k
        if (q.size() < k)
            q.offer(val);
        else if (q.peek() < val) {
            // if len(heaq) == k, and val greater than smallest num
            // then pop smallest num than add val to heap
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */