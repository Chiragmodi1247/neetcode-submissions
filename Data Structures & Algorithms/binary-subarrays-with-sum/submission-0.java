public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefixSum = 0, res = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            res += count.getOrDefault(prefixSum - goal, 0);
            count.put(prefixSum, count.getOrDefault(prefixSum, 0) + 1);
        }

        return res;
    }
}