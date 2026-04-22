class Solution {
    int[] parent;
    int[] rank;
    int connectedComponents;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0;i<n;i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        connectedComponents = n;
        for(int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return connectedComponents;
    }
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return;
        } 
        if (rank[px] < rank[py]) {
            parent[px] = py;
            rank[py]++;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
            rank[px]++;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        connectedComponents--;
    }
}
