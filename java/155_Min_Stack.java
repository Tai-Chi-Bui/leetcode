/*
 * Problem: 155. Min Stack
 * 
 * Description:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 * - MinStack() initializes the stack object
 * - void push(int val) pushes the element val onto the stack
 * - void pop() removes the element on the top of the stack
 * - int top() gets the top element of the stack
 * - int getMin() retrieves the minimum element in the stack
 * 
 * Requirements:
 * - All operations must be O(1) time complexity
 * - Support standard stack operations plus getMin()
 * 
 * Example:
 * Input: ["MinStack","push","push","push","getMin","pop","top","getMin"]
 *        [[],[-2],[0],[-3],[],[],[],[]]
 * Output: [null,null,null,null,-3,null,0,-2]
 * 
 * Constraints:
 * - -2^31 <= val <= 2^31 - 1
 * - Methods pop, top and getMin operations will always be called on non-empty stacks
 * - At most 3 * 10^4 calls will be made to push, pop, top, and getMin
 */

import java.util.ArrayList;
import java.util.List;

/* class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.size() == 0 || x <= minStack.peek()) minStack.push(x);
    }
    
    public void pop() {
        if (stack.size() > 0) {
            int curr = stack.pop();
            if (minStack.size() > 0 && curr == minStack.peek()) minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if (minStack.size() > 0) 
            return minStack.peek();
        else
            return stack.peek();
    }
} */

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.size() == 0 || x <= minStack.peek()) minStack.push(x);
        else minStack.push(minStack.peek());
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
