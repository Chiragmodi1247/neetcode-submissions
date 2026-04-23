class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String w : strs) {
            String k = generateKey(w);
            map.computeIfAbsent(k, x -> new ArrayList<>()).add(w);
        }

        List<List<String>> res = new ArrayList<>();
        for(var e : map.entrySet()) {
            res.add(e.getValue());
        }
        return res;
    }
    private String generateKey(String input) {
        int[] freq = new int[26];
        for(char c : input.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++) {
            sb.append(freq[i]).append("#");
        }
        return sb.toString();
    }
}
