/*
 * Problem: 605. Can Place Flowers
 * 
 * Description:
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers
 * cannot be planted in adjacent plots. Given an integer array flowerbed containing 0's and 1's, where
 * 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted
 * in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * 
 * Requirements:
 * - Check if n flowers can be planted
 * - Flowers cannot be adjacent
 * - Return true if possible, false otherwise
 * 
 * Example:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * 
 * Constraints:
 * - 1 <= flowerbed.length <= 2 * 10^4
 * - flowerbed[i] is 0 or 1
 * - There are no two adjacent flowers in flowerbed
 * - 0 <= n <= flowerbed.length
 */

public class Solution {
    /*public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
             if(count >= n)
                return true;
            i++;
        }
        return false;
    }*/
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0, curr;
        for (int i = 0; i < flowerbed.length; i++) {
            curr = flowerbed[i];
            if (i - 1 >= 0) curr += flowerbed[i - 1];
            if (i + 1 < flowerbed.length) curr += flowerbed[i + 1];
            if (curr == 0) {
                count++;
                flowerbed[i] = 1;
            }
            if (count >= n) return true;
        }
        return false;
    }
}
