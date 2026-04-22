class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        wordSet.remove(beginWord);

        if (!wordSet.contains(endWord)) return 0;

        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                String curr = q.poll();
                if (curr.equals(endWord)) return level;

                char[] chars = curr.toCharArray();

                int currLength = chars.length;
                for(int j=0;j<currLength;j++) {
                    char original = chars[j];
                    for(char c='a';c<='z';c++) {
                        if (c == original) continue;
                        chars[j] = c;
                        String currString = new String(chars);
                        if (wordSet.contains(currString)) {
                            q.offer(currString);
                            wordSet.remove(currString);
                        }
                    }
                    chars[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
}
