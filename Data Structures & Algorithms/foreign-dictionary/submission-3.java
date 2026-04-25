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

      // iterate
      int n = words.length;
      for(int i=1;i<n;i++) {
        String w1 = words[i-1];
        String w2 = words[i];

        if(w1.length() > w2.length() && w1.startsWith(w2)) {
            return "";
        }

        int len = Math.min(w1.length(), w2.length());
        for(int j=0;j<len;j++) {
            char c1 = w1.charAt(j);
            char c2 = w2.charAt(j);

            if(c1 != c2) {
                if(!graph.get(c1).contains(c2)) {
                    graph.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                }
                break;
            };
        }
      }

      Queue<Character> q = new LinkedList<>();
      for(char c : indegree.keySet()) {
        if (indegree.get(c) == 0) {
            q.offer(c);
        }
      }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for(char ch : graph.get(c)) {
                indegree.put(ch, indegree.get(ch) - 1);
                if (indegree.get(ch) == 0) {
                    q.offer(ch);  
                }
            }
        }
        
    if(sb.length() != indegree.size()) return "";
      return sb.toString();
    }
}
