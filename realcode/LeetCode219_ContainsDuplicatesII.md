### [LeetCode #219 - Contains Duplicates II](https://leetcode.com/problems/contains-duplicate-ii/description/)

### Thought
Keep a window of size of *k+1* and use a set to track elements in the window


```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i - left > k) {
                set.remove(nums[left++]);
            }
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
```
### Complexity 
O(N) time & space
### Notes