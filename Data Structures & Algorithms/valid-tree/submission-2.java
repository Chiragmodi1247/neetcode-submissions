class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        int[] parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int pu = find(parent, edge[0]);
            int pv = find(parent, edge[1]);
            if (pu == pv) return false;
            parent[pv] = pu;
        }
        return true;
    }

    private int find(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
