### [LeetCode #230 - Kth Largest in Array](https://leetcode.com/submissions/detail/142201139/)

### Thought
Using QuickSelect to achieve linear runtime on average. 
Algorithm:
	
	1. write a partition function
		- choose a random pivot, in this case, the first element is chosen
		- maintain two pointers i and j such that all the elements to the left of i are non greater than the pivot and all the elements to the right of j are greater than the pivot
		- go over elements in the array, swap elements pointed by i and j if they are out of order
		- when i and j crosses we have found a correct position where the pivot element should be placed in the original array.
	2. call partition on the original array, we get an index paritioning the array into two halves. The kth value needs to be in either one of them.
	3. recurse on the correct half of the subarray.
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKth(nums, nums.length - k);
    }
    
    public int findKth(int[] nums, int v) {
        int p = partition(nums);
        if (p == v) return nums[p];
        if (p < v) return findKth(Arrays.copyOfRange(nums, p + 1, nums.length), v - p - 1);
        return findKth(Arrays.copyOfRange(nums, 0, p), v);
    }
    public int partition(int[] nums) {
        if (nums.length == 1) return 0;
        int pivot = nums[0];
        int i = 0, j = nums.length - 1;
        for (;i <= j;) {
            if (nums[i] <= pivot) {
                ++i;
            } 
            else {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j--] = t;
            }
        }
        nums[0] = nums[j];
        nums[j] = pivot;
        return j;
    }
}
```
### Complexity 
O(N) time on average, O(N^2^) in the worst case. Suppose the array is in sorted order, every call to partition may only creates a subcase that is one smaller than the original array, resulting in quadratic runtime.

### Notes
* In order to achieve good average runtime, we may want to shuffle the array first.
* We can further improve space efficiency by running using left and right pointers to manipulate on the original array instead creating copies of subarrays.