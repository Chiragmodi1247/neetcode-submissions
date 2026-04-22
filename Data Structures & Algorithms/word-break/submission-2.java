class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        int maxWordLen = 0;
        for(String w : wordDict) {
            maxWordLen = Math.max(maxWordLen, w.length());
        }
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=n;i++) {
            for(int j=Math.max(0, i - maxWordLen);j<i;j++) {
                if(dp[j] && dict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
