/*
 * Problem: 1108. Defanging an IP Address
 * 
 * Description:
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 * 
 * Requirements:
 * - Replace every "." with "[.]"
 * - Return the defanged IP address string
 * 
 * Example:
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * 
 * Constraints:
 * - The given address is a valid IPv4 address
 */

class Solution {
    public String defangIPaddr(String address) {
        // replace
        return address.replace(".", "[.]");
    }
    /* public String defangIPaddr(String address) {
        // split and join
        return String.join("[.]", address.split("\\."));
    } */
    /* public String defangIPaddr(String address) {
        // replace
        return address.replaceAll("\\.", "[.]");
    } */
    /* public String defangIPaddr(String address) {
        // new string
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            sb.append(c == '.' ? "[.]" : c);
        }
        return sb.toString();
    } */
}
