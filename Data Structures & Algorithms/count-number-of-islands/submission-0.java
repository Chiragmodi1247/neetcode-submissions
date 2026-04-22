class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if ((grid[i][j] == '1')) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        int n = grid.length;
        int m = grid[0].length;
        if (r < 0 || c < 0 || r >= n || c >= m)
            return;
        if (grid[r][c] == '0') return;
        grid[r][c] = '0';

        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}
