class Solution {
    int maxLen = 0, start = 0;
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        for(int i=0;i<s.length();i++) {
            expand(s, i, i); // odd
            expand(s, i, i+1); // even
        }
        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int l, int r) {
        int n = s.length();
        while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            r++;
            l--;
        }
        int len = (r-l+1) - 2;
        if(len > maxLen) {
            maxLen = len;
            start = l+1;
        }
    }
}
