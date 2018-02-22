### [LeetCode #405 - Convert a Number to Hex](https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/)

### Thought
Group every four bits in a single group. Masking a group with 15 will produce the index into the correct hex decimal representation for that group.
```java
class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] map = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder ret = new StringBuilder();
        while (num != 0) {
            ret = ret.insert(0, map[num & 15]);
            num >>>= 4;
        }
        return ret.toString();
    }
}
```
### Complexity 
O(1) time  & space complexity as we right shift a constant number of times
### Notes
