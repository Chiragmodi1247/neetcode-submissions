class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n,0) + 1);
        }
        for(var e : freq.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
