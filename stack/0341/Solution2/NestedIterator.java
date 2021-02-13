import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Iterator;

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
     * 真*迭代器
    */

    Stack<NestedInteger> items = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        ListIterator<NestedInteger> it = nestedList.listIterator(nestedList.size());

        while (it.hasPrevious()) {
            items.push(it.previous());
        }
    }

    @Override
    public Integer next() {
        return items.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (items.empty()) {
            return false;
        } else {
            if (!items.peek().isInteger()) {
                List<NestedInteger> top = items.pop().getList();
                ListIterator<NestedInteger> it = top.listIterator(top.size());

                while (it.hasPrevious()) {
                    items.push(it.previous());
                }

                return hasNext();
            } 
            return true;
        }
    }
}
