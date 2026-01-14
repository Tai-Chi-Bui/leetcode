/*
 * Problem: 22. Generate Parentheses
 * 
 * Description:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * Requirements:
 * - Generate all well-formed parentheses combinations
 * - n pairs of parentheses
 * - Return list of all valid combinations
 * 
 * Example:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * 
 * Constraints:
 * - 1 <= n <= 8
 */

class Solution {
  	// main function
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        rec(list, "(", n - 1, n);
        return list;
    }
    
	// axiom : if start == end == 0, add str in list.
	// IDEA :
	// In well-formed parentheses
	// close character(")") has to be bigger than open character("(")
	// So, we can solve this problem with recursion.
    public void rec(List<String> list, String str, int start, int end) {
        if(start == 0 && end == 0) {
            list.add(str);
        }
        
        if(start > 0) {
            rec(list, str + "(", start - 1, end);
        }
        if(end > start) {
            rec(list, str + ")", start, end - 1);
        }
    }
}
