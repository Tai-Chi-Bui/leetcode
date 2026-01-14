"""
Problem: 811. Subdomain Visit Count

Description:
A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level,
we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com",
we will also visit the parent domains "leetcode.com" and "com" implicitly. A count-paired domain is a domain that has been
visited numVisits times. For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates "discuss.leetcode.com"
was visited 9001 times. Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each
subdomain in the input. You may return the answer in any order.

Requirements:
- Count visits for each subdomain
- Include parent domains in count
- Return list of count-paired domains

Example:
Input: cpdomains = ["9001 discuss.leetcode.com"]
Output: ["9001 discuss.leetcode.com","9001 leetcode.com","9001 com"]
Explanation: We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.

Constraints:
- 1 <= cpdomain.length <= 100
- 1 <= cpdomain[i].length <= 100
- cpdomain[i] follows the "repi d1i.d2i.d3i" format
- repi is an integer in the range [1, 10^4]
- d1i, d2i, and d3i consist of lowercase English letters
"""

class Solution(object):
    def subdomainVisits(self, cpdomains):
        """
        :type cpdomains: List[str]
        :rtype: List[str]
        """
        domain_count = {}
        for cpdomain in cpdomains:
            count, domain = cpdomain.split(' ')
            sub_domain = domain.split('.')
            for i in range(len(sub_domain)):
                curr = '.'.join(sub_domain[i:])
                domain_count[curr] = domain_count.get(curr, 0) + int(count)
        return [str(v) + ' ' + k for k, v in domain_count.items()]


    # def subdomainVisits(self, cpdomains):
    #     # https://leetcode.com/problems/subdomain-visit-count/discuss/121770/Python-short-and-understandable-solution-68-ms
    #     counter = collections.Counter()
    #     for cpdomain in cpdomains:
    #         count, *domains = cpdomain.replace(" ",".").split(".")
    #         for i in range(len(domains)):
    #             counter[".".join(domains[i:])] += int(count)
    #     return [" ".join((str(v), k)) for k, v in counter.items()]
