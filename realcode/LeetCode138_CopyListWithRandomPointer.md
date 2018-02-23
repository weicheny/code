### [LeetCode #138 - Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/description/)

### Thought
For the first pass, we build all the new nodes and keep a map that maps old nodes to new nodes. In the second pass, we finish off the random pointer. A new node's random pointer can be found by following the corresponding old node's random pointer. The mapping for the old random node is the new random node.
```python
# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        d = dict()
        h = head
        while head:
            d[head] = head.random
            head = head.next
        dummy = RandomListNode(-1)
        temp = dummy
        while h:
            temp.next = RandomListNode(h.label)
            temp = temp.next
            temp.random = RandomListNode(d[h].label) if d[h] else None
            h = h.next
        return dummy.next
```
### Complexity 
O(N) time & space
### Notes
* can do this in O(1) space see [here](https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N))
LeetCode #138 - Copy List with Random Pointer
Thought
For the first pass, we build all the new nodes and keep a map that maps old nodes to new nodes. In the second pass, we finish off the random pointer. A new node’s random pointer can be found by following the corresponding old node’s random pointer. The mapping for the old random node is the new random node.

# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        d = dict()
        h = head
        while head:
            d[head] = head.random
            head = head.next
        dummy = RandomListNode(-1)
        temp = dummy
        while h:
            temp.next = RandomListNode(h.label)
            temp = temp.next
            temp.random = RandomListNode(d[h].label) if d[h] else None
            h = h.next
        return dummy.next
Complexity
O(N) time & space

Notes
can do this in O(1) space see here
Markdown 1440 bytes 169 words 36 lines Ln 36, Col 192 HTML 819 characters 162 words 32 paragraphs
