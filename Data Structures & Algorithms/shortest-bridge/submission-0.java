class Solution {
    private static final int[][] DIRS = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
    public int shortestBridge(int[][] grid) {
        boolean found = false;
        int n = grid.length;
        for(int i=0;i<n && !found;i++) {
            for(int j=0;j<n && !found;j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                    found = true;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
            
                for(int[] d : DIRS) {
                    int nr = r + d[0], nc = c + d[1];
                    if(nr >= n || nr < 0 || nc >= n || nc < 0) continue;
                    if(grid[nr][nc] == 1) return steps;
                    if(grid[nr][nc] == 0) {
                        q.offer(new int[]{nr, nc});
                        grid[nr][nc] = 2;
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int[][] grid, int r, int c) {
        int n = grid.length;
        if(r >= n || r < 0 || c >= n || c < 0 || grid[r][c] != 1) return;
        grid[r][c] = 2;
        for(int[] d : DIRS) {
            dfs(grid, r + d[0], c + d[1]);
        }
    }
}