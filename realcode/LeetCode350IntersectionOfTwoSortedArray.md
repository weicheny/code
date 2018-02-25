### [LeetCode #350 - Intersection of Two Sorted Array II](https://leetcode.com/problems/intersection-of-two-arrays-ii/description/)

Assuming there are no duplicates in both arrays and both are already sorted.
The idea is similar to Sort Merge Join.
1. Swap array if the first array is larger than the second.
2. Loop over the first array while performing binary search on the second.
3. Terminate when either array goes out of bounds
### Thought

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        if (nums1.length >  nums2.length) {
            int [] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        //Arrays.sort(nums1);
        //Arrays.sort(nums2);
        List<Integer> ret = new ArrayList<>();
        for (int i = 0, lo = 0, hi = nums2.length - 1; i < nums1.length && lo <= hi; ++i) {
            int val = Arrays.binarySearch(nums2, lo, hi+1, nums1[i]);
            if (val >= 0) {
                ret.add(nums2[val]);
                lo = val + 1;
            }
            else {
                lo = -val - 1;
            }
        }
        int [] r = new int[ret.size()];
        for (int x = 0; x < ret.size(); ++x) r[x] = ret.get(x); 
        return r;
    }
}
```
### Complexity 
O(N + logM) time. The complexity analysis is worth discussion here. It would be tempting to think that it runs in O(N*logM) time because we are iterating over N while binary searching M elements. However, the state of the binary search, namely, *lo* and *hi* are preserved across iterations. When we have lower bound equal to upper bound, we do not loop anymore.

### Notes
* Having duplicates will fail the algorithm 
* We can use hash tables with counters to achieve O(M + N) runtime for  arrays with duplicates.