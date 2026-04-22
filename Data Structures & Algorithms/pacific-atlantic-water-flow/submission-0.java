class Solution {
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] art = new boolean[rows][cols];

        for(int c=0;c<cols;c++) {
            dfs(0, c, pac, heights);
            dfs(rows-1, c, art, heights);
        }
        for(int r=0;r<rows;r++) {
            dfs(r, 0, pac, heights);
            dfs(r, cols-1, art, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(pac[i][j] && art[i][j])
                res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        int rows = heights.length;
        int cols = heights[0].length;
        for(int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr >= 0 && nc >=0 && nr < rows && nc < cols
            && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr,nc,ocean,heights);
            }
        }
    }
}
