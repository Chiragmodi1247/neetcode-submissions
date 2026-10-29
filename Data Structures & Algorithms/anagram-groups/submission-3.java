class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String s : strs) {
            String freqKey = getFreqKey(s);
            if(map.containsKey(freqKey)) {
                map.get(freqKey).add(s);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(freqKey, temp);
            }
        }
        for(String s : map.keySet()) {
            ans.add(map.get(s));
        }
        return ans;
    }

    private String getFreqKey(String input) {
        int[] freq = new int[26];
        for(char c : input.toCharArray()) {
            freq[c-'a']++;
        }
        StringBuilder key = new StringBuilder();
        for(int i=0;i<26;i++) {
            key.append(freq[i]).append("#");
        }
        return key.toString();
    }
}
