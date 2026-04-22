class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // initialise
        for(String w : words) {
            for(char c : w.toCharArray()) {
                graph.put(c, new HashSet<>());
                indegree.put(c, 0);
            }
        }

        // check edges
        int n = words.length;
        for(int i=0;i<n-1;i++) {
            String w1 = words[i];
            String w2 = words[i+1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int len = Math.min(w1.length(), w2.length());
            for(int j=0;j<len;j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    if(!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(var e : indegree.entrySet()) {
            if(e.getValue() == 0) {
                q.offer(e.getKey());
            }
        }

        StringBuilder result = new StringBuilder();
        while(!q.isEmpty()) {
            char c = q.poll();
            result.append(c);
            for(char neighbour : graph.get(c)) {
                indegree.put(neighbour, indegree.get(neighbour) - 1);
                if(indegree.get(neighbour) == 0) {
                    q.offer(neighbour);
                }
            }
        }

        if(result.length() != indegree.size()) return "";
        return result.toString();
    }
}
