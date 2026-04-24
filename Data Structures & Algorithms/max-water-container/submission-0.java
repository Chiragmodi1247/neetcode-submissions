class Solution {
    public int maxArea(int[] heights) {
        int l = 0, n = heights.length;
        int r = n-1;
        int maxArea = Integer.MIN_VALUE;
        while(l < r) {
            int currArea = Math.min(heights[r], heights[l]) * (r-l);
            maxArea = Math.max(maxArea, currArea);
            if(heights[r] < heights[l]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}
