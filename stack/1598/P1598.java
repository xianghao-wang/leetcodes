class Solution {
    public int minOperations(String[] logs) {
        int stack = 0;
        for (String log : logs) {
            if (log.equals("./")) {
                continue;
            }

            if (log.equals("../")) {
                stack = stack == 0 ? 0 : stack - 1;
            } else {
                stack ++;
            }
        }

        return stack;
    }
}