class Solution {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] monoStack = new int[len];
        // Put the last element on the stack to avoid unnecessary checks
        monoStack[0] = prices[len - 1];
        int top = 0; // This cursor points to the current top of the stack

        for (int i = len - 2; i >= 0; i--) {
            // Remove elements from the stack that are greater than the current price
            while (top >= 0 && monoStack[top] > prices[i]) {
                // We just move the stack cursor, but that's enough and saves resources
                top--;
            }

            // Push the original value before updating
            monoStack[top + 1] = prices[i];

            // Update the current price with the discount if exist
            if (top >= 0) {
                prices[i] -= monoStack[top];
            }

            // Move stack cursor to original value in stack
            top++;
        }
        return prices;
    }
}