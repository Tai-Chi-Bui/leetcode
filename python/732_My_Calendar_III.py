"""
Problem: 732. My Calendar III

Description:
A k-booking happens when k events have some non-empty intersection (i.e., there is some time that is common to all k events.)
You are given some events [start, end), after each given event, return an integer k representing the maximum k-booking from all the previous events.
Implement the MyCalendarThree class:
- MyCalendarThree() Initializes the object
- int book(int start, int end) Returns an integer k representing the largest integer such that there exists a k-booking in the calendar

Requirements:
- Track maximum overlapping events
- Return maximum k-booking after each event
- Return the maximum k value

Example:
Input: ["MyCalendarThree", "book", "book", "book", "book", "book", "book"], [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
Output: [null, 1, 1, 2, 3, 3, 3]

Constraints:
- 0 <= start < end <= 10^9
- At most 400 calls will be made to book
"""

from sortedcontainers import SortedDict


class MyCalendarThree:
  def __init__(self):
    self.timeline = SortedDict()

  def book(self, start: int, end: int) -> int:
    self.timeline[start] = self.timeline.get(start, 0) + 1
    self.timeline[end] = self.timeline.get(end, 0) - 1

    ans = 0
    activeEvents = 0

    for count in self.timeline.values():
      activeEvents += count
      ans = max(ans, activeEvents)
