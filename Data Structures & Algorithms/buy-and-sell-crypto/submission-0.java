class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxP = 0;
        int n = prices.length;
        while(r < n) {
            if(prices[r] > prices[l]) {
                maxP = Math.max(maxP, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return maxP;
    }
}
