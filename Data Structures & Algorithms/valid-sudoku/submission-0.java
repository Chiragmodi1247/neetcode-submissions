class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] boxSet = new HashSet[9];

        for(int i=0;i<9;i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for(int r=0;r<9;r++) {
            for(int c=0;c<9;c++) {
                char ch = board[r][c];
                if(ch == '.') continue;

                int box = (r/3)*3 + (c/3);
                if(!rowSet[r].add(ch)) return false;
                if(!colSet[c].add(ch)) return false;
                if(!boxSet[box].add(ch)) return false;
            }
        }
        return true;
    }
}
