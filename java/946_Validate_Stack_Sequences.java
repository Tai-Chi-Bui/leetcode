/*
 * Problem: 946. Validate Stack Sequences
 * 
 * Description:
 * Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result
 * of a sequence of push and pop operations on an initially empty stack, or false otherwise.
 * 
 * Requirements:
 * - Check if popped sequence is valid for given pushed sequence
 * - Stack operations: push and pop
 * - Return true if valid, false otherwise
 * 
 * Example:
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence: push(1), push(2), push(3), push(4), pop() -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 
 * Constraints:
 * - 1 <= pushed.length <= 1000
 * - 0 <= pushed[i] <= 1000
 * - All the elements of pushed are unique
 * - popped.length == pushed.length
 * - popped is a permutation of pushed
 */

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> inStack = new Stack<>();
        int posPush = 0, posPop = 0;
        while (posPush != pushed.length) {
            int curr = pushed[posPush];
            while (!inStack.empty() && popped.length > 0 && inStack.peek() == popped[posPop]) {
                inStack.pop();
                posPop++;
            }
            if (popped.length == 0) break;
            if (curr == popped[posPop]) posPop++;
            else inStack.push(curr);
            posPush++;
        }
        while (!inStack.empty() && popped.length > 0 && inStack.peek() == popped[posPop]) {
            inStack.pop();
            posPop++;
        }
        if (inStack.empty()) return true;
        return false;
    }
}
