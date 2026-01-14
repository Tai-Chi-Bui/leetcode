/*
 * Problem: 405. Convert a Number to Hexadecimal
 * 
 * Description:
 * Given an integer num, return a string representing its hexadecimal representation.
 * For negative integers, two's complement method is used.
 * 
 * Requirements:
 * - Convert integer to hexadecimal string
 * - Handle negative numbers using two's complement
 * - Return lowercase hexadecimal string
 * 
 * Example:
 * Input: num = 26
 * Output: "1a"
 * 
 * Input: num = -1
 * Output: "ffffffff"
 * 
 * Constraints:
 * - -2^31 <= num <= 2^31 - 1
 */

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

class Solution {
    public String toHex(int num) {
        String hex_map = "0123456789abcdef";
        if (num == 0) return "0";
        String res = "";
        // To avoid infinite loop caused by negative num
        while (num != 0 && res.length() < 8) {
            res = hex_map.charAt(num & 15) + res;
            num = num >> 4;
        }
        return res;
    }

    /* public String toHex(int num) {
        String hex = Integer.toHexString(num);
        return hex;
    } */
}
