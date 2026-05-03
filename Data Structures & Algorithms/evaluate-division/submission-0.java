class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int size = values.length;
        for(int i=0;i<size;i++) {
            List<String> temp = equations.get(i);
            double tempVal = values[i];
            graph.computeIfAbsent(temp.get(0), x -> new HashMap<>()).put(temp.get(1), tempVal);
            graph.computeIfAbsent(temp.get(1), x -> new HashMap<>()).put(temp.get(0), 1.0/tempVal);
        }

        double[] results = new double[queries.size()];
        for(int i=0;i<queries.size();i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            results[i] = bfs(src, dst, graph);
        }
        return results;
    }

    private double bfs(String src, String dst, Map<String, Map<String, Double>> graph) {
        if(!graph.containsKey(src) || !graph.containsKey(dst)) return -1.0;
        if(src.equals(dst)) return 1.0;

        Set<String> visited = new HashSet<>();
        Queue<String> nodeQ = new LinkedList<>();
        Queue<Double> productQ = new LinkedList<>();

        nodeQ.offer(src);
        productQ.offer(1.0);
        visited.add(src);
        while(!nodeQ.isEmpty()) {
            String node = nodeQ.poll();
            double cost = productQ.poll();
            if(node.equals(dst)) return cost;

            for(var e : graph.get(node).entrySet()) {
                if(!visited.contains(e.getKey())) {
                    nodeQ.offer(e.getKey());
                    productQ.offer(cost * e.getValue());
                }
            }
        }
        return -1.0;
    }
}