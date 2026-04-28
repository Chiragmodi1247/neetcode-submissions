class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int l = 0;
        int n = s.length();
        Map<Character, Integer> lastSeen = new HashMap<>();
        
        for(int r=0;r<n;r++) {
            char c1 = s.charAt(r);
            if(lastSeen.containsKey(c1)) {
                l = Math.max(l, lastSeen.get(c1) + 1);
            }
            lastSeen.put(c1,r);
            longest = Math.max(longest, r-l + 1);
        }
        return longest;
    }
}
