class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {return i1[1] - i2[1];});

        int availableCount = 0;
        int curEndTime = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1];
            if (startTime >= curEndTime) {
                availableCount++;
                curEndTime = endTime;
            }
        }

        return intervals.length - availableCount;
    }
}