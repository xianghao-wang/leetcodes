class Solution {
    public String makeGood(String s) {
        StringBuilder ans = new StringBuilder();

        int len = s.length();
        for (int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            if (ans.length() == 0 || !isBad(ans.charAt(ans.length() - 1), c)) {
                ans.append(c);
            } else {
                ans.deleteCharAt(ans.length() - 1);
            }
        }

        return ans.toString();
    }

    public boolean isBad(char a, char b) {
        return Math.abs(a - b) == 'a' - 'A';
    }
}