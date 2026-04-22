/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNewCopy = new HashMap<>();
        
        return dfs(node, oldToNewCopy);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNewCopy) {
        if(node == null) return null;
        if(oldToNewCopy.containsKey(node)) return oldToNewCopy.get(node);

        Node newCopy = new Node(node.val);
        oldToNewCopy.put(node, newCopy);

        for(Node nc : node.neighbors) {
            newCopy.neighbors.add(dfs(nc, oldToNewCopy));
        }
        return newCopy;
    }
}