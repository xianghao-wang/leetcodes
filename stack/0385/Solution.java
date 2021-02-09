import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class NestedInteger {
    public NestedInteger() {}
    public NestedInteger(int value) {}
    public boolean isInteger() { return false; }
    public Integer getInteger() { return 0; }
    public void setInteger(int value) {}
    public void add(NestedInteger ni) {}
    public List<NestedInteger> getList() { return null; }
}

class Solution {
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();

        int p = 0;
        while (p < s.length()) {
            char c = s.charAt(p);

            if (c == '[') {
                stack.push(new NestedInteger());
            } else if (c == ']') {
                NestedInteger top = stack.peek();
                if (stack.size() != 1) {
                    stack.pop();
                    stack.peek().add(top);
                }
            } else if (c != ',') {
                int x = 0;
                int sign = 1;
                if (s.charAt(p) == '-') {
                    sign = -1;
                    p ++;
                }
                while (p < s.length()) {
                    if (s.charAt(p) == ',') {
                        break;
                    }
                    if (s.charAt(p) == ']') {
                        p --;
                        break;
                    }

                    x = x * 10 + s.charAt(p) - '0';

                    p ++;
                }

                x *= sign;

                if (stack.empty()) {
                    stack.push(new NestedInteger(x));
                } else {
                    stack.peek().add(new NestedInteger(x));
                }
            }

            p ++;
        }

        return stack.peek();
    }
}