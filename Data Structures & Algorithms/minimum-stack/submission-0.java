class MinStack {
    long min;
    Stack<Long> s;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()) {
            s.push(0L);
            min = val;
        } else {
            s.push(val - min);
            if(val < min) min = val;
        }
    }
    
    public void pop() {
        if(s.isEmpty()) return;
        long pop = s.pop();
        if(pop < 0) min = min - pop;
    }
    
    public int top() {
        long top = s.peek();
        if(top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
