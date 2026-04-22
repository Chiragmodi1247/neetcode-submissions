class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        for(int a : nums) {
            int pos = Collections.binarySearch(tails, a);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            if(pos == tails.size()) {
                tails.add(a);
            } else {
                tails.set(pos, a);
            }
        }
        return tails.size();
    }
}
