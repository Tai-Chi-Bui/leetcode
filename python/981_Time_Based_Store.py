"""
Problem: 981. Time Based Key-Value Store

Description:
Design a time-based key-value data structure that can store multiple values for the same key at different time stamps
and retrieve the key's value at a certain timestamp. Implement the TimeMap class:
- TimeMap() Initializes the object of the data structure
- void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp
- String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp.
  If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".

Requirements:
- Store key-value pairs with timestamps
- Retrieve value for key at or before given timestamp
- Return value with largest timestamp <= given timestamp

Example:
Input: ["TimeMap", "set", "get", "get", "set", "get", "get"], [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output: [null, null, "bar", "bar", null, "bar2", "bar2"]

Constraints:
- 1 <= key.length, value.length <= 100
- key and value consist of lowercase English letters and digits
- 1 <= timestamp <= 10^7
- All the timestamps timestamp of set are strictly increasing
- At most 2 * 10^5 calls will be made to set and get
"""

from collections import defaultdict

class TimeMap(object):

    def __init__(self):
        self.store = defaultdict(list)

    def set(self, key, value, timestamp):
        self.store[key].append((value, timestamp))

    def get(self, key, timestamp):
        values = self.store.get(key, [])
        res = ""

        l = 0
        r = len(values) - 1

        while l <= r:
            mid = (l + r) // 2
            if values[mid][1] <= timestamp:
                l = mid + 1
                res = values[mid][0]
            else:
                r = mid - 1
        
        return res
