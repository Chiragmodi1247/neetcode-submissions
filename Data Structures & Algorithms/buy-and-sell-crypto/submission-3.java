class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, n = prices.length, maxP = 0;
        for(int r=1;r<n;r++) {
            if(prices[r] > prices[l]) {
                maxP = Math.max(maxP, prices[r] - prices[l]);
            } else {
                l = r;
            }
        }
        return maxP;
    }
}
