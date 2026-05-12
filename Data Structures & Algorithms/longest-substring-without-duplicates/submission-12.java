class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int l = 0, n = s.length();
        int ans = 0;
        for(int r=0;r<n;r++) {
            char c1 = s.charAt(r);
            if(lastSeen.containsKey(c1)) {
                l = Math.max(l, lastSeen.get(c1) + 1);
            }
            lastSeen.put(c1, r);
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}
