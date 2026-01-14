"""
Problem: 1310. XOR Queries of a Subarray

Description:
Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri],
for each query i compute the XOR of elements from Li to Ri (that is, arr[Li] XOR arr[Li+1] XOR ... XOR arr[Ri]).
Return an array containing the result for the given queries.

Requirements:
- Process multiple queries on the array
- For each query [Li, Ri], compute XOR of all elements in the range [Li, Ri]
- Return results for all queries

Example:
Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8]
Explanation: 
The binary representation of the elements in the array are:
1 = 0001
3 = 0011
4 = 0100
8 = 1000
The XOR values for queries are:
[0,1] = 1 XOR 3 = 2
[1,2] = 3 XOR 4 = 7
[0,3] = 1 XOR 3 XOR 4 XOR 8 = 14
[3,3] = 8

Constraints:
- 1 <= arr.length <= 3 * 10^4
- 1 <= arr[i] <= 10^9
- 1 <= queries.length <= 3 * 10^4
- queries[i].length == 2
- 0 <= queries[i][0] <= queries[i][1] < arr.length
"""

class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        pref = [0]
        # Compute accumulated xor from head
        for e in arr:
            pref.append(e ^ pref[-1])
        ans = []
        # query result equal to xor[0, l] xor x[0, r]
        for [l, r] in queries:
            ans.append(pref[r+1] ^ pref[l])
        return ans

    # def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
    #     for i in range(len(arr) - 1):
    #         arr[i + 1] ^= arr[i]
    #     return [arr[j] ^ arr[i - 1] if i else arr[j] for i, j in queries]
