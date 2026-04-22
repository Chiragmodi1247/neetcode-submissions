class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        tails.add(nums[0]);

        int LIS = 1;
        for(int i=1;i<nums.length;i++) {
            if(tails.get(tails.size() - 1) < nums[i]) {
                tails.add(nums[i]);
                LIS++;
                continue;
            }
            int idx = Collections.binarySearch(tails, nums[i]);
            if(idx < 0) idx = -idx - 1;
            tails.set(idx, nums[i]);
        }
        return LIS;
    }
}
