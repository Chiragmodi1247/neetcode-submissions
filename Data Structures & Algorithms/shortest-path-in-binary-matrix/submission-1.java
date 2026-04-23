class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0] = 1;

        int[][] directions = 
            new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        int steps = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                if(r == n-1 && c == n-1) return steps;
                for(int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && grid[nr][nc] != 1) {
                            q.offer(new int[]{nr, nc});
                            grid[nr][nc] = 1;
                        }
                }
            }
            steps++;
        }
        return -1;
    }
}