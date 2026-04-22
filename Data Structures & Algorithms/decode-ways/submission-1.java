class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        // int[] dp = new int[n + 1];
        // dp[n] = 1;
        int prev2 = 1;
        int prev1 = 1;
        int curr = 0;
        for(int i=n-1;i>=0;i--) {
            if(s.charAt(i) == '0') {
                curr = 0;
            } else {
                curr = prev1;
                if (i + 1 < n && (s.charAt(i) == '1' ||
                s.charAt(i) == '2' && s.charAt(i+1) < '7')) {
                    curr += prev2;
                }
            }
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
