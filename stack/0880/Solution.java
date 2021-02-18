class Solution {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        for (int i = 0; i < S.length(); i ++) {
            if (Character.isDigit(S.charAt(i))) {
                size *= S.charAt(i) - '0';
            } else {
                size += 1;
            }
        }

        for (int i = S.length() - 1; i >= 0; i --) {
            char c = S.charAt(i);

            if (K <= size) {

            }

            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                size --;
            }
        }

        return "";
    }
}