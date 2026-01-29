class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // minimum price so far
        int maxProfit = 0; // maximum profit so far

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // update min price
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // update max profit
            }
        }

        return maxProfit;
    }
}