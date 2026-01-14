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

#define pb push_back
class Solution {
public:
    vector<string> fizzBuzz(int n) {
        int i;
        vector<string> s;
        for (i = 0; i < n; i++) {
            if ((i + 1) % 15 == 0)
                s.pb("FizzBuzz");
            else if ((i + 1) % 5 == 0)
                s.pb("Buzz");
            else if ((i + 1) % 3 == 0)
                s.pb("Fizz");
            else
                s.pb(to_string(i + 1));
        }
        return s;
    }
};
