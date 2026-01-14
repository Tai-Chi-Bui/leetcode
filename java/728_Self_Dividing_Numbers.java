/*
 * Problem: 728. Self Dividing Numbers
 * 
 * Description:
 * A self-dividing number is a number that is divisible by every digit it contains. For example, 128 is
 * a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0. A self-dividing number
 * is not allowed to contain the digit zero. Given two integers left and right, return a list of all the
 * self-dividing numbers in the range [left, right].
 * 
 * Requirements:
 * - Find all self-dividing numbers in range [left, right]
 * - Self-dividing number is divisible by all its digits
 * - Number cannot contain digit 0
 * - Return list of self-dividing numbers
 * 
 * Example:
 * Input: left = 1, right = 22
 * Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
 * 
 * Constraints:
 * - 1 <= left <= right <= 10^4
 */

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        LinkedList list = new LinkedList();
        for(int i = left; i <= right; i++) {
            if(isSelfDiving(i))
            list.add(i);
        }
        return list;
    }
    
    public boolean isSelfDiving(int num) {
            int digit = num % 10;
            int temp = num;
            boolean isTrue = true;
            while(temp != 0) {
                // 0 is special
                if(digit == 0 || num % digit != 0) {
                    isTrue = false;
                    break;
                } else {
                    temp /= 10;
                    digit = temp % 10;
                }
            }
            return isTrue;
    }
}
