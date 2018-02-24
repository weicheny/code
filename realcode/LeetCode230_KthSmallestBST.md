### [LeetCode #230 - Kth Smallest BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/)

### Thought
Find the node that has exactly *k-1* smaller nodes. Recursion will do.

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root.left == null && root.right == null) return root.val;
        int left = size(root.left), right = size(root.right);
        if (left == k - 1) return root.val;
        if (left < k - 1) return kthSmallest(root.right, k - left - 1);
        return kthSmallest(root.left, k);
    }
    
    public int size(TreeNode root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }
}
```
### Complexity 
O(N) time & space
- The complexity analysis is interesting here. For each call to count node, it does O(N) work where N is the number of nodes. However, every subcall will only work on half of the nodes remaining thanks to binary search tree properties.
* Thus we have O(work) = 1 + 2 + 4 + ... + N = 2N
### Notes
We can improve our complexity by a constant factor, using inorder traversal such that every node is visited exactly once.