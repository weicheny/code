### [LeetCode #179 - Largest Number](https://leetcode.com/problems/largest-number/description/)

### Thought
Write custom comparator that compares strings in alphanumeric order. Combine them to get the final result. Use Java 8 features, online source.
```java
public class Solution {
    public String largestNumber(int[] num) {
        String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }
}
```
### Complexity 
O(NlogN) time and O(N) space
### Notes
* Java stream, both array and collection containers have stream method
	* Support map reduce and functional style programming
	* parallelStream can parallelize sequential code, but has side effect on stateful operations
	* optionalInt, optionalDouble are returned for some operations
```java
linkedList.stream()
	      .filter(v -> v % 2 == 0)
	 	  .mapToDouble(z -> Math.sqrt(z))
	      .average()
	      .getAsDouble()

int sumOfWeights = widgets.parallelStream()
                          .filter(b -> b.getColor() == RED)
                          .mapToInt(b -> b.getWeight())
                          .sum();
int sum = numbers.stream().reduce(0, (x,y) -> x+y);
```
* lambda comparator
 ```java 
Arrays.sort(array, new Comparator<String>() {
	public int compare(String a, String b) {
		return a.compareTo(b);
}
Arrays.sort(array, (a, b)->(a+b).compareTo(b+a));

```