/*
 * Problem: 706. Design HashMap
 * 
 * Description:
 * Design a HashMap without using any built-in hash table libraries. Implement the MyHashMap class:
 * - MyHashMap() initializes the object with an empty map
 * - void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value
 * - int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
 * - void remove(int key) removes the key and its corresponding value if the map contains the mapping for the key
 * 
 * Requirements:
 * - Implement HashMap with put, get, remove operations
 * - Handle key collisions
 * - Return -1 if key not found in get operation
 * 
 * Example:
 * Input: ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 *        [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * Output: [null, null, null, 1, -1, null, 1, null, -1]
 * 
 * Constraints:
 * - 0 <= key, value <= 10^6
 * - At most 10^4 calls will be made to put, get, and remove
 */

class MyHashMap {
    final ListNode[] nodes = new ListNode[10000];
    // https://leetcode.com/problems/design-hashmap/discuss/152746/Java-Solution
    public void put(int key, int value) {
        int i = idx(key);
        if (nodes[i] == null)
            nodes[i] = new ListNode(-1, -1);
        ListNode prev = find(nodes[i], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }

    public int get(int key) {
        int i = idx(key);
        if (nodes[i] == null)
            return -1;
        ListNode node = find(nodes[i], key);
        return node.next == null ? -1 : node.next.val;
    }

    public void remove(int key) {
        int i = idx(key);
        if (nodes[i] == null) return;
        ListNode prev = find(nodes[i], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }

    int idx(int key) { return Integer.hashCode(key) % nodes.length;}

    ListNode find(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
