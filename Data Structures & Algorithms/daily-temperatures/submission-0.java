class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()])  {
                int prev = s.pop();
                result[prev] = i - prev;
            }
            s.push(i);
        }
        return result;
    }
}
