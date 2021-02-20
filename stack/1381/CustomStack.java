class CustomStack {
    private int[] diffs; // 相邻元素的差值
    private int size; // 栈的大小
    private int cur; // 当前栈顶元素的值
    private int maxSize;

    public CustomStack(int maxSize) {
        diffs = new int[maxSize + 1];
        size = 0;
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (size == maxSize) {
            return;
        }

        /* 将新元素和原栈顶元素的差值入栈 */
        diffs[size] = size == 0 ? x : x - cur;

        /* 更新栈顶元素 */
        cur = x;

        size ++;
    }
    
    public int pop() {
        if (size == 0) {
            return -1;
        }

        int ret = cur;

        size --;
        cur -= diffs[size];

        return ret;
    }
    
    public void increment(int k, int val) {
        if (size == 0) {
            return;
        }

        /* 差分数组操作 */
        diffs[0] += val;
        diffs[k > size ? size : k] -= val;

        if (size <= k) {
            cur += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */