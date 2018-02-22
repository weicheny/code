### [LeetCode #2 - Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/)

### Thought
Add two numbers in reverse order in linked list notation is very similar to how we add two numbers manually. Starting from the least significant digit and remember the carry as we go.
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(-1), temp = h;
        int c = 0, val = 0;
        while (l1 != null || l2 != null) {
            val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;   
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;   
            }
            val += c;
            c = val / 10;
            temp.next = new ListNode(val % 10);
            temp = temp.next;
        }
        if (c != 0) temp.next = new ListNode(1);
        return h.next;
    }
}
```


### Complexity 
O(N), linear to the total number of nodes in the two numbers

