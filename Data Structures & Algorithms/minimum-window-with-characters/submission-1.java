class Solution {
    public String minWindow(String s, String t) {
        if (t == null || t.isEmpty()) return "";
        if (s == null || s.isEmpty()) return "";

        int minLen = Integer.MAX_VALUE, resStart = -1;

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int have = 0, required = need.size();

        int left = 0;
        for(int right = 0;right<s.length();right++) {
            char ch = s.charAt(right);
            window.merge(ch, 1, Integer::sum);

            if(need.containsKey(ch) && window.get(ch).intValue() == need.get(ch).intValue()) {
                have++;
            }
            while(have == required) {
                int len = right - left + 1;
                if(len < minLen) {
                    minLen = len;
                    resStart = left;
                }
                char leftChar = s.charAt(left);
                window.merge(leftChar, -1, Integer::sum);
                if(need.containsKey(leftChar) && window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    have--;
                }
                left++;
            }
        }    
        System.out.println("resStart: " + resStart);
        System.out.println("Len: " + minLen);
        return resStart == -1 ? "" : s.substring(resStart, resStart+minLen);
    }
}
