/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        for(Interval a : intervals) {
            if(!pq.isEmpty() && pq.peek().end <= a.start) {
                pq.poll();
            }
            pq.offer(a);
        }
        return pq.size();
    }
}
