### [LeetCode #200 - Number of Islands](https://leetcode.com/problems/number-of-islands/description/)

### Thought
Use DFS to traverse grid. Mark each visited entry to avoid repetition.
```java
class Solution {
    private boolean [][] visited;
    private final int[][] dirs = {{1,0}, {-1,0}, {0,1},{0,-1}};
    private int ret = 0;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++ret;
                }
            }
        }
        return ret;
    }
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '2';
        for (int [] dir: dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    } 
}
```
### Complexity 
O(M*N) time & O(1) space where M is row count and N is column count.


### Notes
* we call *dfs* function at most M*N times
* we can modify the grid in place to acheive constant space complexity
* **Union Find** can be used  if we map 2D entry into 1D