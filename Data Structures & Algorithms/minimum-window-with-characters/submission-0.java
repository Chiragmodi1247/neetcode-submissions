class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> have = new HashMap<>();
        int formed = 0;
        int required = need.size();

        int l = 0, ansL = 0, ansR = 0;
        int minLen = Integer.MAX_VALUE;

        for(int r=0;r<s.length();r++) {
            char ch = s.charAt(r);
            have.put(ch, have.getOrDefault(ch, 0) + 1);

            if(need.containsKey(ch) && need.get(ch) == have.get(ch)) {
                formed++;
            }

            while(formed == required) {
                if(r-l+1 < minLen) {
                    minLen = r-l+1;
                    ansL = l;
                    ansR = r+1;
                }
                char lc = s.charAt(l);
                have.put(lc, have.get(lc) - 1);
                if(need.containsKey(lc) && have.get(lc) < need.get(lc)) {
                    formed--;
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);
    }
}
