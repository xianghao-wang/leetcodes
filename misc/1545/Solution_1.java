class Solution_1 {
    public char findKthBit(int n, int k) {
        String s = "0";
        for (int i = 0; i < n; i ++) {
            s = s + "1" + reverse(invert(s));
        }

        return s.charAt(k - 1);
    }

    public String reverse(String s) {
        StringBuilder ret = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i --) {
            ret.append(s.charAt(i));
        }

        return ret.toString();
    }

    public String invert(String s) {
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i ++) {
            chs[i] = chs[i] == '0' ? '1' : '0';
        }

        return new String(chs);
    }
}