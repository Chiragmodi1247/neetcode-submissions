class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringToKeyMap = new HashMap<>();
        for(String s : strs) {
            String k = generateKey(s);
            stringToKeyMap.computeIfAbsent(k,
                x -> new ArrayList<>()).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for(String s : stringToKeyMap.keySet()) {
            result.add(stringToKeyMap.get(s));
        }
        return result;
    }
    private String generateKey(String s) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for(int i=0;i<26;i++) {
            sb.append(freq[i]).append("#");
        }
        return sb.toString();
    }
}
