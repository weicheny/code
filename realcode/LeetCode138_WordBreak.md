### [LeetCode #138 - Word Break](https://leetcode.com/problems/word-break/description/)

### Thought
Use dp array *arr[i]* represents whether the previous i characters can be found in *wordDict*. Value at position i can be true when some words fits in and previous entry is also set to true.
```python
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] arr = new boolean[s.length()+1];
        arr[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (String str: wordDict) {
                if (s.startsWith(str, i-1) && arr[i-1]) 
                    arr[i+str.length()-1] = true;
            }
        }
        return arr[arr.length-1];
    }
}
```
### Complexity 
O(N) time & space
### Notes
* String.startsWith(String s, int index)