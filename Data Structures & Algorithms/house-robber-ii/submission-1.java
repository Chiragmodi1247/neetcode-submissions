class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robRange(nums, 0, n-1), robRange(nums, 1, n));
    }

    private int robRange(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        int ans = Integer.MIN_VALUE;
        for(int i=start;i<end;i++) {
            ans = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}
