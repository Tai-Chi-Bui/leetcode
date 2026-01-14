"""
Problem: 997. Find the Town Judge

Description:
In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
If the town judge exists, then:
1. The town judge trusts nobody
2. Everybody (except for the town judge) trusts the town judge
3. There is exactly one person that satisfies properties 1 and 2
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

Requirements:
- Find the town judge
- Judge trusts nobody
- Everyone else trusts the judge
- Return judge's label or -1 if not found

Example:
Input: n = 2, trust = [[1,2]]
Output: 2

Constraints:
- 1 <= n <= 1000
- 0 <= trust.length <= 10^4
- trust[i].length == 2
- All the pairs of trust are unique
- ai != bi
- 1 <= ai, bi <= n
"""

class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if N==1:
            return 1
        d1={}
        d2={}
        for i, j in trust:
            if j in d1:
                d1[j]+=1
            else:
                d1[j]=1
            if i in d2:
                d2[i]+=1
            else:
                d2[i]=1
        for i,j in d1.items():
            if j==N-1:
                if i not in d2:
                    return i
        return -1
                    
