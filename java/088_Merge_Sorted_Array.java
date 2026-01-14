/*
 * Problem: 88. Merge Sorted Array
 * 
 * Description:
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two
 * integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums2 into nums1 as one sorted array. The final sorted array should not be returned by
 * the function, but instead be stored inside the array nums1.
 * 
 * Requirements:
 * - Merge nums2 into nums1 in-place
 * - Result should be sorted in non-decreasing order
 * - nums1 has length m + n, with first m elements being valid
 * - nums2 has length n
 * 
 * Example:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6]. The result is [1,2,2,3,5,6].
 * 
 * Constraints:
 * - nums1.length == m + n
 * - nums2.length == n
 * - 0 <= m, n <= 200
 * - 1 <= m + n <= 200
 * - -10^9 <= nums1[i], nums2[j] <= 10^9
 */

class Solution {
    //we are being given two int arrays and two int variables that state the number of elements in each array, respectively
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //I am using a counter so that I can iterate through the second array inside the for loop
        int counter = 0;
        //We know that nums1 is of the size n + m, so we can add all the elements to the array and sort them later
        //For loop adds all values of nums2 to the end of nums1
        for(int i=m; i<nums1.length; i++){
            nums1[i] = nums2[counter++];
        }
        //Now that all of the elements are in the array, we can begin the sort process
        //Though we could use the Arrays.sort function to quickly sort the array, I wanted to implement a sorting algorithm myself
        //I am implementing what's called a "Bubble Sorting Algorithm" to sort this array
        //This should work best in our scenario as we don't have to work with a large list of numbers
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums1.length-i-1; j++){
                if(nums1[j] > nums1[j+1]){
                    int temp = nums1[j+1];
                    nums1[j+1] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
        //The following function simply prints out everything that is contained within our num1 array
        for(int i=0; i<nums1.length; i++){
            System.out.println(nums1[i]);
        }
    }
}