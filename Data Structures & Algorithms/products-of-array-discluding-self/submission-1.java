class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixMultiplication = new int[n];
        prefixMultiplication[0] = 1;
        for(int i=1;i<n;i++) {
            prefixMultiplication[i] = prefixMultiplication[i-1] * nums[i-1];
        }
        int[] result = new int[n];
        result[n-1] = prefixMultiplication[n-1];
        int prev = nums[n-1];
        for(int i=n-2;i>=0;i--) {
            result[i] = prefixMultiplication[i] * prev;
            prev *= nums[i];
        }
        return result;
    }
}  
