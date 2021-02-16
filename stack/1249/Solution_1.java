import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indicesToRemove = new HashSet<>();
        Stack<Integer> indicesOfLeftBrace = new Stack<>();

        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                indicesOfLeftBrace.push(i);
            } else if (s.charAt(i) == ')') {
                if (indicesOfLeftBrace.empty()) {
                    indicesToRemove.add(i);
                } else {
                    indicesOfLeftBrace.pop();
                }
            }
        }

        
        while (!indicesOfLeftBrace.empty()) { indicesToRemove.add(indicesOfLeftBrace.pop()); }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            if (!indicesToRemove.contains(i)) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}