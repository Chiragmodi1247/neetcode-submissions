class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for(int r=0;r<routes.length;r++) {
            for(int stop : routes[r]) {
                stopToRoutes.computeIfAbsent(stop, x -> new ArrayList<>()).add(r);
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] routeVisited = new boolean[routes.length];

        dq.offer(source);
        int buses = 0;
        while(!dq.isEmpty()) {
            int sz = dq.size();
            for(int i=0;i<sz;i++) {
                int stop = dq.poll();
                if(stop == target) return buses;
                for(int nextRoute : stopToRoutes.getOrDefault(stop, List.of())) {
                    if(routeVisited[nextRoute]) continue;
                    routeVisited[nextRoute] = true;
                    for(int nextStop : routes[nextRoute]) {
                        dq.offer(nextStop);
                    }
                }
            }
            buses++;
        }
        return -1;
    }
}