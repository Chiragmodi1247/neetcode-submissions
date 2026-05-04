class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> keyMap = new HashMap<>();
        int counter = 0;
        for(String w : strs) {
            String key = generateKey(w);
            if(keyMap.containsKey(key)) {
                result.get(keyMap.get(key)).add(w);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(w);
                result.add(temp);
                keyMap.put(key, counter);
                counter++;
            }
        }
        return result;
    }

    private String generateKey(String word) {
        int[] freq = new int[26];
        for(char c : word.toCharArray()) {
            freq[c-'a']++;
        }
        StringBuilder key = new StringBuilder();
        for(int i=0;i<26;i++) {
            key.append(freq[i]).append('#');
        }
        return key.toString();
    }
}
