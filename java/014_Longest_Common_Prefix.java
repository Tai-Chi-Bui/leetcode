/*
 * Problem: 14. Longest Common Prefix
 * 
 * Description:
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * Requirements:
 * - Find the longest common prefix among all strings in the array
 * - Return empty string if no common prefix exists
 * 
 * Example:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * Constraints:
 * - 1 <= strs.length <= 200
 * - 0 <= strs[i].length <= 200
 * - strs[i] consists of only lowercase English letters
 */

//014_Longest_Common_Prefix.java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result ="";
        String temp = "";
        int c = 0; //move first point
        boolean check = true;
        while(true){
            for(int i = 0; i<strs.length; i++){ //move second point
                if(c>=strs[i].length()){
                    check = false;
                    break;
                }
                if(i==0){ //temp -> check same Character
                    temp = Character.toString(strs[0].charAt(c));
                }
                if(!temp.equals(Character.toString(strs[i].charAt(c)))){
                    check = false;
                    break;
                }
                if(i==strs.length-1){
                    result += temp;
                }
            }
            if(!check){
                break;
            }
            c++;
        }
        return result;
        
    }
}