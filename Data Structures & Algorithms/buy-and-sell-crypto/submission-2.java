class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1, maxP = 0, n=prices.length;
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
