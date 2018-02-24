### [LeetCode #239 - Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/description/)

### Thought
Like LRU cache, we need a way to invalidate the oldest entry in our data structure. A doubly linked list will do this  with head and tail pointers.  Here are some key points:
1. We store indices in our deque structure, so that we know when to evict an entry by checking *i - k + 1*
2. It is important to note that the newest added entry is always relevant, because it can become the biggest at some latter point
3. We maintain a decreasing order in the deque, so that the front of the queue is always the currently maximum value for the current window
4. we kick out a value when it falls out of scope
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0) return new int[0];
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; ++i) {
            if (!dq.isEmpty() && dq.peekFirst() == i - k) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.add(i);
            if (i >= k - 1) ret[i-k+1] = nums[dq.peekFirst()]; 
        }
        
        return ret;
    }
}
```
### Complexity 
O(N) time & space
### Notes
* the Deque interface in Java has methods to get and poll both ends of the structure