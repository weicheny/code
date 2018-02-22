### [LeetCode #93 - Flatten 2D Vector](https://leetcode.com/problems/flatten-2d-vector/description/)

### Thought
Using two level pointer where the outer pointer points to a list and inner points to where we are at in the current list. 
Both int indices and iterators will work for this problem.
#### Java Simulate Iterator
```java
public class Vector2D implements Iterator<Integer> {
    private int i1, i2;
    private List<List<Integer>> vec;

    public Vector2D(List<List<Integer>> vec2d) {
        vec = vec2d;
    }

    @Override
    public Integer next() {
        return vec.get(i1).get(i2++);
    }

    @Override
    public boolean hasNext() {
        if (i1 < vec.size() && i2 < vec.get(i1).size()) return true;
        while (++i1 < vec.size() && vec.get(i1).size() == 0);
        i2 = 0;
        return i1 < vec.size();
    }
}  
```
#### Java Real Iterator (online source)
```java
public class Vector2D {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public int next() {
        hasNext();
        return j.next();
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }
}
```
### Complexity 
O(N) time & O(1) space for both solutions


### Notes
* it is important to know how the code is tested; we need to know whether we are guaranteed to call *hasNext* before calling *next*