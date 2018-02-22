### [LeetCode #75 - Sort Colors](https://leetcode.com/problems/sort-colors/description/)

### Thought
Famous problem also dubbed "Dutch National Flag Problem". 
Setup three pointers, *left* points to the index where all the elements to its left are 0s. *right* points to the index where all the elements to its right are 2s. *cur* points to the current index we are iterating over.
Stopping condition: *cur <= right*, because we don't need to check beyond *right* as they are all 2s.
```java
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                int temp = nums[left];
                nums[left++] = 0;
                nums[cur++] = temp;
            }
            else if (nums[cur] == 2) {
                int temp = nums[right];
                nums[right--] = 2;
                nums[cur] = temp;
            }
            else {
                ++cur;
            }
        }
    }
}
```
### Complexity 
O(N) time & O(1) space

### Notes
<li> maintain loop invariant and keep swapping and updating according to rules