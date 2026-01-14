/*
 * Problem: 179. Largest Number
 * 
 * Description:
 * Given a list of non-negative integers nums, arrange them such that they form the largest number
 * and return it. Since the result may be very large, so you need to return a string instead of an integer.
 * 
 * Requirements:
 * - Arrange numbers to form the largest possible number
 * - Return as string (to handle large numbers)
 * - Handle leading zeros (if result starts with 0, return "0")
 * 
 * Example:
 * Input: nums = [10,2]
 * Output: "210"
 * 
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * 
 * Constraints:
 * - 1 <= nums.length <= 100
 * - 0 <= nums[i] <= 10^9
 */

class Solution {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
           return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }
        return largestNumberStr;
    }
}
