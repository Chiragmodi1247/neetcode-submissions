class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> enclose = new HashSet<>(Set.of('(', '{', '['));
        // Set<Character> closing = new HashSet<>(Set.of(')', '}', ']'));
        for(char c : s.toCharArray()) {
            if (enclose.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char p = stack.pop();
                if ((p == '[' && c != ']')
                    || (p == '{' && c != '}')
                    || (p == '(' && c != ')')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
