### [LeetCode #93 - Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/description/)

### Thought
The problem is specified in IPV4 format. An address is formed by a.b.c.d, where a, b, c, d are integers between 0 and 255, inclusive. It can be solved using typical backtracking technique.
Keep track of *index* as the current index, *cur* as the current result string(complete or incomplete IP address), *ret* as an accumulator where the return result is stored.
1. at current index, we have options to take 1, 2, or 3 digits as a number and append it to our current IP address and we recursively call *dfs* as we have made a decision above.
2. we terminate as soon as the *cur* is invalid, either a number is out of range, or there are more than 4 numbers already. 
3. sometimes we need to backtrack, meaning that if a choice we made previously need to be undone as we might need to try another choice.

```python
class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        ret = []
        self.dfs(s, 0, '', ret)
        return ret
    
    def dfs(self, s, index, cur, ret):
        if cur.count('.') > 3: return
        elif cur.count('.') == 3:
            if index >= len(s):
                ret.append(cur)
            return
        for i in range(index, min(index+3, len(s))):
            check = s[index:i+1]
            toAdd = check if not cur else '.' + check
            cur += toAdd
            if (check[0] != '0' and 0 < int(check) <= 255) or check == '0':
                self.dfs(s, i+1, cur, ret)    
            cur = cur[:len(cur)-len(toAdd)]	#backtrack step
       
```
### Complexity 
O(N^3^) time & space. We can think of the process as trying to find three places to insert ".", making a string valid IP address. 


### Notes
* although str.count function takes O(N) time, we can easily use an extra parameter to keep track of number of dots we've seen so far. Reducing complexity from O(N^4^) to O(N^3^)