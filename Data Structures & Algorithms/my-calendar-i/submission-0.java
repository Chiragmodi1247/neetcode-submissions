class MyCalendar {

    private static class TreeNode {
        int start,end;
        TreeNode left, right;

        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }
    }

    TreeNode root;

    public MyCalendar() {
        root = null;
    }

    private boolean insert(TreeNode node, int startTime, int endTime) {
        if(endTime <= node.start) {
            if(node.left == null) {
                node.left = new TreeNode(startTime, endTime);
                return true;
            }
            return insert(node.left, startTime, endTime);
        } else if (startTime >= node.end) {
            if(node.right == null) {
                node.right = new TreeNode(startTime, endTime);
                return true;
            }
            return insert(node.right, startTime, endTime);
        }
        return false;
    }
    
    public boolean book(int startTime, int endTime) {
        if(root == null) {
            root = new TreeNode(startTime, endTime);
            return true;
        }
        return insert(root, startTime, endTime);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */