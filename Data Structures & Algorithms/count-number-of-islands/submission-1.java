class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islands = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int r, int c) {
        int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        int m = grid.length, n = grid[0].length;
        grid[r][c] = '0';
        for(int i=0;i<4;i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if(nr == m || nr < 0 || nc == n || nc < 0) continue;
            if(grid[nr][nc] == '1') {
                dfs(grid, nr, nc);
            }
        }
    }
}
