### [LeetCode #3 - Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)

### Thought
Keep a map to record the index of a character. Let *start* be the left boundary of the current window that contains no duplicate and *longest* be the length of current longest substring with no repeating characters.
1. if current character not in map, directly update *longest* and then update *map*
2. else, update *start* to be one position right since the current character is repeated, and then *longest* and then *map*


```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, longest = 0;
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            start = Math.max(start, m.getOrDefault(s.charAt(i), -1) + 1);
            longest = Math.max(longest, i - start + 1);
            m.put(s.charAt(i), i);
        }
        return longest;
    }
}
```


### Complexity 
O(N) time & space

### Notes
<li> use map.getOrDefault in Java to set the appropriate default value. 
<li> can use int[26], int[52], int[128] instead of map if we know the range of characters from 'a' to 'z', 'A' to 'Z', or ASCII