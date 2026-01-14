"""
Problem: 904. Fruit Into Baskets

Description:
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer
array fruits where fruits[i] is the type of fruit the ith tree produces. You want to collect as much fruit as possible. However,
the owner has some strict rules that you must follow:
- You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
- Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
- The picked fruits must fit in one of your baskets.
- Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Requirements:
- Pick fruits from trees moving right
- Can only hold two types of fruit
- Must pick one fruit from each tree until can't continue
- Return maximum number of fruits

Example:
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.

Constraints:
- 1 <= fruits.length <= 10^5
- 0 <= fruits[i] < fruits.length
"""

class Solution(object):
    # def totalFruit(self, tree):
    #     """
    #     :type tree: List[int]
    #     :rtype: int
    #     """
    #     basket, res, start = 2, 0, 0
    #     queue_map = {}
    #     for i, v in enumerate(tree):
    #         queue_map[v] = queue_map.get(v, 0) + 1
    #         if len(queue_map) > 2:
    #             queue_map[tree[start]] -= 1
    #             if queue_map[tree[start]] == 0:
    #                 del queue_map[tree[start]]
    #             start += 1
    #         res = max(res, i - start + 1)
    #     return res

    # https://leetcode.com/problems/fruit-into-baskets/solution/
    # def totalFruit(self, tree):
    #     blocks = [(k, len(list(v)))
    #               for k, v in itertools.groupby(tree)]
    #     ans = i = 0
    #     while i < len(blocks):
    #         # We'll start our scan at block[i].
    #         # types : the different values of tree[i] seen
    #         # weight : the total number of trees represented
    #         #          by blocks under consideration
    #         types, weight = set(), 0

    #         # For each block from i and going forward,
    #         for j in xrange(i, len(blocks)):
    #             # Add each block to consideration
    #             types.add(blocks[j][0])
    #             weight += blocks[j][1]
    #             # If we have 3 types, this is not a legal subarray
    #             if len(types) >= 3:
    #                 i = j-1
    #                 break
    #             ans = max(ans, weight)
    #         # If we go to the last block, then stop
    #         else:
    #             break
    #     return ans

    def totalFruit(self, tree):
        ans = i = 0
        count = collections.Counter()
        for j, x in enumerate(tree):
            count[x] += 1
            while len(count) >= 3:
                count[tree[i]] -= 1
                if count[tree[i]] == 0:
                    del count[tree[i]]
                i += 1
            ans = max(ans, j - i + 1)
        return ans
