class Solution {
    public static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(root.children[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, root, result);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }
        char ch = board[r][c];
        if(ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];
        if(node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';

        dfs(board, r+1, c, node, result);
        dfs(board, r-1, c, node, result);
        dfs(board, r, c+1, node, result);
        dfs(board, r, c-1, node, result);

        board[r][c] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words) {
            TrieNode node = root;
            for(char c : w.toCharArray()) {
                if(node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = w;
        }
        return root;
    }
}
