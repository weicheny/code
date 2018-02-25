### [LeetCode #230 - Ugly Number II](https://leetcode.com/problems/ugly-number-ii/description/)

### Thought
Brilliant solution found online. 
Let *ugly* be the array that stores first n ugly numbers.
*i2, i3, i5* are indices within the *ugly* array  whose purpose is to find the first number that is bigger than the current largest in *ugly*
The three indices keep updating themselves until the first numbers whose product with 2, 3, and 5 respectively are greater than current largest.
Append the minimum of the three to array

#### Python Elegant Solution
```python
class Solution:
	def nthUglyNumber(self, n):
	    ugly = [1]
	    i2 = i3 = i5 = 0
	    while len(ugly) < n:
	        while ugly[i2] * 2 <= ugly[-1]: i2 += 1
	        while ugly[i3] * 3 <= ugly[-1]: i3 += 1
	        while ugly[i5] * 5 <= ugly[-1]: i5 += 1
	        ugly.append(min(ugly[i2] * 2, ugly[i3] * 3, ugly[i5] * 5))
	    return ugly[-1]
```
#### Python Brute Force
```python
class Solution:
    ugly = sorted(2**a * 3**b * 5**c
                  for a in range(32) for b in range(20) for c in range(14))
    def nthUglyNumber(self, n):
        return self.ugly[n-1]
```
### Complexity 
O(N) time & space

### Notes
* avoid adding duplicates 
* using generators can be memory efficient

	```
	for i in (j for j in range(1000000000000)):
	    pass
    ```