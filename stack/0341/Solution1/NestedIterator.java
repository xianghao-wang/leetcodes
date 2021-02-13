import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}


public class NestedIterator implements Iterator<Integer> {
    /**
     * 头重脚轻，一口气读取所有元素 
    */
    Deque<Integer> items = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        traversal(nestedList);
    }

    @Override
    public Integer next() {
        return items.pollFirst();
    }

    @Override
    public boolean hasNext() {
        return !items.isEmpty();
    }

    private void traversal(List<NestedInteger> L) {
        for (NestedInteger x : L) {
            if (x.isInteger()) {
                items.addLast(x.getInteger());
            } else {
                traversal(x.getList());
            }
        }
    }
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */