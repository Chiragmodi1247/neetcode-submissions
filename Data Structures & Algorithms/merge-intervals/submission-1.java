class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        for(int[] a : intervals) {
            if(result.isEmpty()
            || result.get(result.size() - 1)[1] < a[0]) {
                result.add(a);
            } else {
                result.get(result.size() - 1)[1] 
                    = Math.max(a[1], result.get(result.size() - 1)[1]);
            }
        }
        return result.toArray(new int[0][]);
    }
}
