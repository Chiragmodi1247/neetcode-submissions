class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int l=0, maxF = 0, res = 0;
        for(int r=0;r<s.length();r++) {
            char c = s.charAt(r);
            char d = s.charAt(l);
            count.put(c, count.getOrDefault(c , 0) + 1);
            maxF = Math.max(maxF, count.get(c));

            while((r-l+1 - maxF) > k) {
                count.put(d, count.get(d) - 1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
