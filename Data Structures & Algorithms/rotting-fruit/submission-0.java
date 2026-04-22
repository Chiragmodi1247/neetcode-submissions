class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;
        int minutes = 0;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n
                    && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
