class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        if (maxSize == 0) return -1;
        if (minSize == maxSize) {
            return (double)(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}
