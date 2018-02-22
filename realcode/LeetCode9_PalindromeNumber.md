### [LeetCode #9 - Palindrome Number](https://leetcode.com/problems/palindrome-number/description/)

### Thought
1. use string representation of number and compare against its reverse
2.  build number backwards, only build half of the digits, e.g.  123321 -> 123=123, 12223 -> 12 != 322
#### Python Build String
```python
class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        #python slicing [::-1] reverse a string easily
        return str(x)[::-1] == str(x)
```
#### Java Build Number (online source)
```java
public boolean isPalindrome(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }
    return (x==rev || x==rev/10);
}
```
### Complexity 
O(N) time for both approaches. Build number more space efficient.

### Notes
<li> do not build a whole reversed integer because this might overflow