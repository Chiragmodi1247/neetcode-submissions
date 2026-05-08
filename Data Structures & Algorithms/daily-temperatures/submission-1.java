class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int top = s.pop();
                result[top] = i-top;
            }
            s.push(i);
        }
        return result;
    }
}
