class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0, r = n-1;
        int maxWater = Integer.MIN_VALUE;
        while(l < r) {
            int water = Math.min(heights[l], heights[r]) * (r - l);
            maxWater = Math.max(maxWater, water);
            if(heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxWater;
    }
}
