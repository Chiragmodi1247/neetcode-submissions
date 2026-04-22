class Solution {
    public int rob(int[] nums) {
        int prev1 = 0, prev2 = 0;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            ans = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}
