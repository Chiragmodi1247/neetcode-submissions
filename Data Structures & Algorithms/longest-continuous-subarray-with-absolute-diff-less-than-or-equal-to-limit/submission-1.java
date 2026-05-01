class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();
        int l = 0, ans = 0;


        for(int r = 0; r<nums.length; r++) {
            while(!maxDq.isEmpty() && nums[maxDq.peekLast()] < nums[r]) {
                maxDq.pollLast();
            }
            maxDq.addLast(r);

            while(!minDq.isEmpty() && nums[minDq.peekLast()] > nums[r]) {
                minDq.pollLast();
            }
            minDq.addLast(r);

            while(nums[maxDq.peekFirst()] - nums[minDq.peekFirst()] > limit) {
                l++;
                if(maxDq.peekFirst() < l) maxDq.pollFirst();
                if(minDq.peekFirst() < l) minDq.pollFirst();
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}