### [LeetCode #53 - Maximum Subarray](https://leetcode.com/problems/maximum-subarray/description/)

### Thought
The maximum subarray ending at index *i* is either the *nums[i]* or *sofar + nums[i]*
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int largest = Integer.MIN_VALUE, sofar = 0;
        for (int i = 0; i < nums.length; ++i) {
            sofar = Math.max(sofar + nums[i], nums[i]);
            largest = Math.max(largest, sofar);
        }
        return largest;
    }
}
```
### Complexity 
O(N) time & O(1) space

### Notes
<li> do not use DP array when we only need a constant value