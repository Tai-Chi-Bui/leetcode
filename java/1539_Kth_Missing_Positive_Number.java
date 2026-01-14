/*
 * Problem: 1539. Kth Missing Positive Number
 * 
 * Description:
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 * Return the kth positive integer that is missing from this array.
 * 
 * Requirements:
 * - Find the kth missing positive integer
 * - Array is sorted in strictly increasing order
 * - Return the kth missing number
 * 
 * Example:
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * 
 * Constraints:
 * - 1 <= arr.length <= 1000
 * - 1 <= arr[i] <= 1000
 * - 1 <= k <= 1000
 * - arr[i] < arr[j] for 1 <= i < j <= arr.length
 */

class Solution {
    public int findKthPositive(int[] a, int k) {
        int B[] = new int[a.length];

        // equation (A)
        // B[i]=a[i]-i-1
        // B[i]=number of missing numbers BEFORE a[i]
        for (int i = 0; i < a.length; i++)
            B[i] = a[i] - i - 1; // -1 is done as here missing numbers start from 1 and not 0

        // binary search upper bound of k
        // smallest value>=k

        int lo = 0, hi = B.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (B[mid] >= k)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        // lo is the answer

        /*
         * now the number to return is a[lo]-(B[lo]-k+1) (EQUATION B)
         * where (B[lo]-k+1) is the number of steps we need to go back
         * from lo to retrieve kth missing number, since we need to find
         * the kth missing number BEFORE a[lo], we do +1 here as
         * a[lo] is not a missing number when B[lo]==k
         * putting lo in equation(A) above
         * B[i]=a[i]-i-1
         * B[lo]=a[lo]-lo-1
         * and using this value of B[lo] in equation B
         * we return a[lo]-(a[lo]-lo-1-k+1)
         * we get lo+k as ans
         * so return it
         */
        return lo + k;
    }
}
