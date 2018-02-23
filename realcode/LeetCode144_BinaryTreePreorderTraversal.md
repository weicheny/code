### [LeetCode #144 - Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/description/)

### Thought
Keep a stack of node to explore. Explore the node popped out of stack and add its right and left children to stack, if there is any.
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
    public List<Integer> preorderTraversal(TreeNode root) {
	    if (root == null) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        LinkedList <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.pollLast();
            ret.add(temp.val);
            if (temp.right != null) queue.add(temp.right);
            if (temp.left != null) queue.add(temp.left);
        }
        return ret;
    }
}
```
### Complexity 
O(N) time & space
### Notes
* use linked list instead of stack, which should be avoided. (exists for compatibility)
