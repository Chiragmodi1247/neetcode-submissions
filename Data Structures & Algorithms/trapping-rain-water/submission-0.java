class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n-1;
        int maxLeft = 0, maxRight = 0, water = 0;

        while(l < r) {
            if(height[l] < height[r]) {
                maxLeft = Math.max(maxLeft, height[l]);
                water += (maxLeft -  height[l]);
                l++;
            } else {
                maxRight = Math.max(maxRight, height[r]);
                water += (maxRight - height[r]);
                r--;
            }
        }
        return water;
    }
}
