### [LeetCode #367 - Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/description/)

### Thought

```java
class Solution {
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = num;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == num / mid && num % mid == 0) return true;
            else if (mid  < num / mid) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
}
```
### Complexity 
O(log N) time O(1) space

### Notes
* Use ```mid = lo + (hi - lo) / 2``` to avoid overflow
* use ```mid = num / mid``` to avoid overflow