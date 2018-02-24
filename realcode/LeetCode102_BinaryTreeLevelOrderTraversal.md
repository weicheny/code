### [LeetCode #102 - Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/description/)

### Thought
Like BFS, traverse level by level. For each level popping all the elements while adding children to the end of queue
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            ret.add(new ArrayList<>());
            for (int i = 0; i < sz; ++i) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                ret.get(ret.size() - 1).add(temp.val);
            }
        }
        return ret;
    }
}
```
### Complexity 
O(N) time & space
### Notes
