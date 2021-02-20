import java.util.HashMap;
import java.util.Map;

class Solution {
    private static Map<String, Character> TOKENS = new HashMap<>();

    static {
        TOKENS.put("&quot;", '\"');
        TOKENS.put("&apos;", '\'');
        TOKENS.put("&amp;", '&');
        TOKENS.put("&gt;", '>');
        TOKENS.put("&lt;", '<');
        TOKENS.put("&frasl;", '/');
    }

    public String entityParser(String text) {
        int pAns = 0, p = 0;
        char[] ans = text.toCharArray();

        while (p < text.length()) {
            ans[pAns] = ans[p];

            if (text.charAt(p) == '&') {
                int t = p;
                while (t < text.length() && text.charAt(t) != ';') {
                    t ++;
                }

                if (t == text.length()) {
                    break;
                } else {
                    String token = text.substring(p, t + 1);
                    for (String key : TOKENS.keySet()) {
                        if (token.equals(key)) {
                            ans[pAns] = TOKENS.get(key);
                            p += key.length() - 1;
                        }
                    }
                }
            }

            p ++; pAns ++;
        }

        return new String(ans, 0, pAns);
    }
}