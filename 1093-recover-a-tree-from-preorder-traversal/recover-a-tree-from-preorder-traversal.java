class Solution {
    private String s;
    private int idx, level;
    
    public TreeNode recoverFromPreorder(String traversal) {
        this.s = traversal;
        this.idx = 0;
        this.level = 0;
        TreeNode node = new TreeNode(-1);
        this.helper(node, 0);
        return node.left;
    }

    private void helper(TreeNode parent, int lvl) {
        while (this.idx < this.s.length() && lvl == level) {
            int num = 0;
            while (this.idx < this.s.length() && Character.isDigit(this.s.charAt(this.idx))) {
                num = num * 10 + (this.s.charAt(this.idx++) - '0');
            }
            TreeNode node = new TreeNode(num);
            if (parent.left == null)
                parent.left = node;
            else
                parent.right = node;
            
            this.level = 0;
            while (this.idx < this.s.length() && this.s.charAt(this.idx) == '-') {
                this.level++;
                this.idx++;
            }
            this.helper(node, lvl + 1);
        }
    }
}