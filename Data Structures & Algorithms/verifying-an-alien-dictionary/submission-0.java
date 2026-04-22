class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        for(int i=0;i<words.length - 1;i++) {
            if (!isInOrder(words[i], words[i+1], rank)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInOrder(String word1, String word2, int[] rank) {
        int minLen = Math.min(word1.length(), word2.length());
        for(int i=0;i<minLen;i++) {
            int c1 = word1.charAt(i); 
            int c2 = word2.charAt(i); 
            if(rank[c1 - 'a'] < rank[c2 - 'a']) return true;
            if(rank[c1 - 'a'] > rank[c2 - 'a']) return false;
        }
        return word1.length() <= word2.length();
    }
}