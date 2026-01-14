/*
 * Problem: 6. Zigzag Conversion
 * 
 * Description:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows.
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows.
 * 
 * Requirements:
 * - Convert string to zigzag pattern with numRows rows
 * - Read the zigzag pattern line by line and return the result
 * 
 * Example:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * Constraints:
 * - 1 <= s.length <= 1000
 * - s consists of English letters (lower-case and upper-case), ',' and '.'
 * - 1 <= numRows <= 1000
 */

//006_ZigZag_Conversion.java
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) {
            return s;
        }

        String answer = "";
        String[] str_array = new String[numRows];

        for(int i=0;i<numRows;i++){
            str_array[i]="";
        }

        int mod = 2*numRows-2;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int index = i%mod;
            if(index >= numRows) {
                index = 2*(numRows-1) - index;
            }
            str_array[index]+=c;
        }

        for(int i=0;i<numRows;i++){
            answer += str_array[i];
        }

        return answer;
    }
}

