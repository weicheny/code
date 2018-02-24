### [LeetCode #221 - Maximum Square](https://leetcode.com/problems/sliding-window-maximum/description/)

### Thought
Using 2D dp array where dp[i][j] represents the maximal width of a square whose bottom right corner sits at (i, j)
We write the following recurrence

* dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1 


```python
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix: return 0
        m, n = len(matrix), len(matrix[0])
        dp = [[0 for i in range(n)] for j in range(m)]
        ret = 0
        for i in range(m):
            if matrix[i][0] == '1':
                ret = 1
                dp[i][0] = 1
        for j in range(n):
            if matrix[0][j] == '1':
                ret = 1
                dp[0][j] = 1
        for i in range(1, m):
            for j in range(1 , n):
                if matrix[i][j] == '1':
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
                ret = max(ret, dp[i][j])
        return ret ** 2
```
### Complexity 
O(M*N) time & space
### Notes
* Space complexity can be reduced to O(M), since it suffices to store the intermediate calculation of the previous row