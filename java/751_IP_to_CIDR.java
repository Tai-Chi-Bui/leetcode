/*
 * Problem: 751. IP to CIDR
 * 
 * Description:
 * An IP address is a formatted 32-bit unsigned integer where each group of 8 bits is printed as a decimal number
 * and the groups are separated by periods (e.g., 192.168.1.1). A CIDR block is a representation of an IP address
 * and its associated network mask. Given a starting IP address ip and a number of IP addresses we need to cover n,
 * return a representation of the CIDR block with the smallest possible length that will cover all the IP addresses
 * in the inclusive range [ip, ip + n - 1].
 * 
 * Requirements:
 * - Convert IP address range to CIDR blocks
 * - Find smallest possible CIDR blocks to cover range
 * - Return list of CIDR block strings
 * 
 * Example:
 * Input: ip = "255.0.0.7", n = 10
 * Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
 * 
 * Constraints:
 * - ip will be a valid IPv4 address
 * - 1 <= n <= 1000
 */

class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        long start = ipToLong(ip);
        List<String> ans = new ArrayList();
        while (n > 0) {
            int mask = Math.max(33 - bitLength(Long.lowestOneBit(start)),
                                33 - bitLength(n));
            ans.add(longToIP(start) + "/" + mask);
            start += 1 << (32 - mask);
            n -= 1 << (32 - mask);
        }
        return ans;
    }
    private long ipToLong(String ip) {
        long ans = 0;
        for (String x: ip.split("\\.")) {
            ans = 256 * ans + Integer.valueOf(x);
        }
        return ans;
    }
    private String longToIP(long x) {
        return String.format("%s.%s.%s.%s",
            x >> 24, (x >> 16) % 256, (x >> 8) % 256, x % 256);
    }
    private int bitLength(long x) {
        if (x == 0) return 1;
        int ans = 0;
        while (x > 0) {
            x >>= 1;
            ans++;
        }
        return ans;
    }
}