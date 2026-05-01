class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r = n-1, resultIndex = n-1;
        while(l <= r) {
            if(Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[resultIndex--] = nums[l] * nums[l];
                l++;
            } else {
                res[resultIndex--] = nums[r] * nums[r];
                r--;
            }
        }
        return res;
    }
}