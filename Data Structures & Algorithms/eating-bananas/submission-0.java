class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for(int n : piles) {
            right = Math.max(right, n);
        }
        int ans = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, mid, h)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    private boolean canEatAll(int[] piles, int k, int h) {
        int timeTaken = 0;
        for(int n : piles) {
            timeTaken += (n + k - 1) / k;
            if (timeTaken > h) return false;
        }
        return timeTaken <= h;
    }
}
