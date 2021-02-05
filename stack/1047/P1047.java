class Solution {
    public String removeDuplicates(String S) {
        StringBuilder ans = new StringBuilder();
        int index = 0;

        for (int i = 0; i < S.length(); i ++) {
            if (index == 0 || ans.charAt(index - 1) != S.charAt(i)) {
                ans.append(S.charAt(i));
                index ++;
            } else {
                ans.deleteCharAt(index - 1);
                index --;
            }
        }

        return ans.toString();
    }
}