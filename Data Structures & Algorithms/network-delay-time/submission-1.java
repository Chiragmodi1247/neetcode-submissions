class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] t : times) {
            graph.computeIfAbsent(t[0], x -> new ArrayList<>()).add(new int[]{t[1], t[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0,k});
        Map<Integer, Integer> dist = new HashMap<>();

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1];

            if(dist.containsKey(node)) {
                continue;
            }
            dist.put(node, cost);
            if(!graph.containsKey(node)) continue;

            for(int[] nei : graph.get(node)) {
                if(!dist.containsKey(nei[0])) {
                    pq.offer(new int[]{cost + nei[1], nei[0]});
                }
            }
        }
        if(dist.size() != n) return -1;
        int maxTime = 0;
        for(int cost : dist.values()) {
            maxTime = Math.max(maxTime, cost);
        }

        return maxTime;
    }
}
