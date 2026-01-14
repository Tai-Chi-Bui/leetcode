/*
 * Problem: 1310. XOR Queries of a Subarray
 * 
 * Description:
 * Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri],
 * for each query i compute the XOR of elements from Li to Ri (that is, arr[Li] XOR arr[Li+1] XOR ... XOR arr[Ri]).
 * Return an array containing the result for the given queries.
 * 
 * Requirements:
 * - Process multiple queries on the array
 * - For each query [Li, Ri], compute XOR of all elements in the range [Li, Ri]
 * - Return results for all queries
 * 
 * Example:
 * Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * Output: [2,7,14,8]
 * Explanation: 
 * The binary representation of the elements in the array are:
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * The XOR values for queries are:
 * [0,1] = 1 XOR 3 = 2
 * [1,2] = 3 XOR 4 = 7
 * [0,3] = 1 XOR 3 XOR 4 XOR 8 = 14
 * [3,3] = 8
 * 
 * Constraints:
 * - 1 <= arr.length <= 3 * 10^4
 * - 1 <= arr[i] <= 10^9
 * - 1 <= queries.length <= 3 * 10^4
 * - queries[i].length == 2
 * - 0 <= queries[i][0] <= queries[i][1] < arr.length
 */

class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        vector<int> res;
        // Compute accumulated xor from head
        for (int i = 1; i < arr.size(); i++)
            arr[i] ^= arr[i - 1];
        for (auto &q: queries)
            res.push_back(q[0] > 0 ? arr[q[0] - 1] ^ arr[q[1]] : arr[q[1]]);
        return res;
    }
};
