class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int expectedSum = 0;

        for(int i=1;i<=nums.length;i++) expectedSum += i;
        for(int num : nums) {
            expectedSum -= num;
        }
        return expectedSum;
    }
}
