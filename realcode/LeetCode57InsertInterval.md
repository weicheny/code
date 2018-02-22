### [LeetCode #57 - Insert Interval](https://leetcode.com/problems/insert-interval/description/)

### Thought
Clean code from online source. Break it down to three components.
1. Intervals who are strictly less than *newInterval*
2. Intervals who are strictly greater than *newInterval*
3. Intervals who intersect with *newInterval*
```python
class Solution:
	def insert(self, intervals, newInterval):
	    s, e = newInterval.start, newInterval.end
	    left, right = [], []
	    for i in intervals:
	        if i.end < s:
	            left += i,
	        elif i.start > e:
	            right += i,
	        else:
	            s = min(s, i.start)
	            e = max(e, i.end)
	    return left + [Interval(s, e)] + right
   
```
### Complexity 
O(N) time & space

### Notes