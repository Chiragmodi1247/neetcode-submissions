class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int l = 0, n=s.length();
        if(n == 0) return 0;
        for(int r=0;r<n;r++) {
            char c = s.charAt(r);
            if(map.containsKey(c)) {
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }
            maxLen = Math.max(maxLen, r - l + 1);
            map.put(c, r);
        }
        return maxLen;
    }
}
