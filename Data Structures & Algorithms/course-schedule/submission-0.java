class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<numCourses;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            inDegree[pre[1]]++;
            graph.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(inDegree[i]==0) {
                q.add(i);
            }
        }

        int finish = 0;
        while(!q.isEmpty()) {
            int c = q.poll();
            finish++;
            for(int nei : graph.get(c)) {
                inDegree[nei]--;
                if(inDegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return finish == numCourses;
    }
}
