import java.util.Stack;

class StockSpanner {
    private static class Stock {
        public int price;
        public int day;
        public Stock(int price, int day) {
            this.price = price;
            this.day = day;
        }
    }

    Stack<Stock> stockFlow; /* [价格, 价格跨度] 单调递减栈 */
    int currentDay;

    public StockSpanner() {
        stockFlow = new Stack<>();
        currentDay = 0;
    }
    
    public int next(int price) {
        while (!stockFlow.empty() && price >= stockFlow.peek().price) {
            stockFlow.pop();
        }

        /* 获得之前更大的股票的天数 */
        int previousBigDay = stockFlow.empty() ? -1 : stockFlow.peek().day;

        /* 添加新的股票  */
        Stock newStock = new Stock(price, currentDay);
        stockFlow.push(newStock);
        currentDay ++;

        return currentDay - 1 - previousBigDay;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */