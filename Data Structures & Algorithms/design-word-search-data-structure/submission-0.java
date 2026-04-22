class TrieNode { 
    TrieNode[] children;
    boolean isEnd;
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}


class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode root, String word, int startIndex) {
        TrieNode curr = root;
        for(int i=startIndex;i<word.length();i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode child : curr.children) {
                    if (child != null && dfs(child, word, i + 1)) {
                        return true;                        
                    }
                }
                return false;
            } else {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
        }
        return curr.isEnd;
    }
}
