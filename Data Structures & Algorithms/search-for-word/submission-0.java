class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int r, int c, String word, int idx) {
        if(idx == word.length()) return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return false;
        if(board[r][c] != word.charAt(idx)) return false;

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found = backtrack(board, r+1, c, word, idx+1)
                        || backtrack(board, r-1, c, word, idx+1)
                        || backtrack(board, r, c+1, word, idx+1)
                        || backtrack(board, r, c-1, word, idx+1);
        
        board[r][c] = temp;
        return found;
    }
}
