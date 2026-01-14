/*
 * Problem: 412. Fizz Buzz
 * 
 * Description:
 * Given an integer n, return a string array answer (1-indexed) where:
 * - answer[i] == "FizzBuzz" if i is divisible by 3 and 5
 * - answer[i] == "Fizz" if i is divisible by 3
 * - answer[i] == "Buzz" if i is divisible by 5
 * - answer[i] == i (as a string) if none of the above conditions are true
 * 
 * Requirements:
 * - Return array of strings from 1 to n
 * - Replace numbers divisible by 3 with "Fizz"
 * - Replace numbers divisible by 5 with "Buzz"
 * - Replace numbers divisible by both 3 and 5 with "FizzBuzz"
 * - Otherwise, return the number as a string
 * 
 * Example:
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * 
 * Constraints:
 * - 1 <= n <= 10^4
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String tmp = "";
            if (i % 3 == 0) tmp += "Fizz";
            if (i % 5 == 0) tmp += "Buzz";
            if (tmp.length() == 0) tmp += String.valueOf(i);
            res.add(tmp);
        } 
        return res;
    }
}
