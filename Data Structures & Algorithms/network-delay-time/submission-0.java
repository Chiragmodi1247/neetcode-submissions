class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        Map<Integer, Integer> dist = new HashMap<>();

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1];

            if(dist.containsKey(node)) continue;
            dist.put(node, cost);

            if(!graph.containsKey(node)) continue;

            for(int[] a : graph.get(node)) {
                if(!dist.containsKey(a[0])) {
                    pq.offer(new int[]{cost + a[1], a[0]});
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
