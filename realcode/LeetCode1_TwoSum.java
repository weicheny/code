### [LeetCode #1 - Two Sum](https://leetcode.com/problems/two-sum/description/)
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap();
        for (int i = 0; i < nums.length;  m.put(nums[i], i++)) {
            if (m.containsKey(target - nums[i]))
                    return new int[]{m.get(target-nums[i]), i};
        }
        return null;
    }
}
```


### Complexity 
O(N) time & space. Alternatively, can use sorting with two pointers to get O(NlogN) time O(1) space
