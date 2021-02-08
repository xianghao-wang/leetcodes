import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> dirs = new LinkedList<>();
        
        int p = 0;

        while (p < path.length() && path.charAt(p) == '/') {
            p ++;
        }
        
        while (p < path.length()) {
            if (!(path.charAt(p) == '/')) {
                int start = p;
                while (p < path.length() && path.charAt(p) != '/') {
                    p ++;
                }

                String cur = path.substring(start, p);
                /* Back to parent dir */
                if (cur.equals("..") && !dirs.isEmpty()) {
                    dirs.pop();
                } else if (!cur.equals("..") && !cur.equals(".")) {
                    /* Enter a dir */
                    dirs.push(cur);
                }
            } else {
                p ++;
            }
        }

        if (dirs.isEmpty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();
        
        while (!dirs.isEmpty()) {
            ans.append('/');
            ans.append(dirs.pollLast());
        }

        return ans.toString();
    }
}