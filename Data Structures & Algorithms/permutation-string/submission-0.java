class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for(char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        for(int r=0;r<s2.length();r++) {
            window[s2.charAt(r) - 'a']++;
            if(r >= s1.length()) {
                window[s2.charAt(r - s1.length()) - 'a']--;
            }
            if(Arrays.equals(window, need)) return true;
        }
        return false;
    }
}
