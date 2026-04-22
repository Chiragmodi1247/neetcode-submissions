class Solution {
    private int[] parent;
    public int countComponents(int n, int[][] edges) {
        int connectedComponents = n;
        parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        for(int[] e : edges) {
            int pu = find(e[0]);
            int pv = find(e[1]);
            if(pu != pv) {
                connectedComponents--;
                parent[pv] = pu;
            }
        }
        return connectedComponents;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
