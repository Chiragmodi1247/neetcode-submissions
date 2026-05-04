class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int a : nums) {
            freq.merge(a, 1, Integer::sum);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freq.get(a) - freq.get(b));
        for(int a : freq.keySet()) {
            pq.offer(a);
            if(pq.size() > k) pq.poll();
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
