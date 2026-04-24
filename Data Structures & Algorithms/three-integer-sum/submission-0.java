class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        // [-4,-1,-1,0,1,2]
        if(n<3) return ans;
        for(int i=0;i<n-2;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // add this
            int l = i+1, r=n-1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(List.of(nums[i],nums[l],nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;  // skip duplicate lefts
                    while (l < r && nums[r] == nums[r - 1]) r--;  // skip duplicate rights
                    l++;
                    r--;
                } else if(sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
