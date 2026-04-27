class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int minutes = 0;
        int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                for(int[] d : dir) {
                    int nr = r + d[0], nc = c + d[1];
                    if(nr >= m || nr < 0 || nc >=n || nc < 0) continue;
                    if(grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}
