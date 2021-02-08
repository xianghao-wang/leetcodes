import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> ans = new LinkedList<>();
        boolean[] used = new boolean[26];
        int[] bucket = new int[26];

        for (int i = 0; i < s.length(); i ++) {
            bucket[s.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            int rank = c - 'a';

            if (!used[rank]) {
                while (!ans.isEmpty()) {
                    if (bucket[ans.getLast() - 'a'] == 0 || ans.getLast() < c) {
                        break;
                    }
    
                    used[ans.getLast() - 'a'] = false;
                    ans.pollLast();
                }
    
                ans.addLast(c);
                used[rank] = true;
            }

            bucket[rank] --;
        }

        StringBuilder ret = new StringBuilder();
        for (char c : ans) {
            ret.append(c);
        }

        return ret.toString();
    }
}