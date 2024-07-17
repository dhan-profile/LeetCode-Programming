/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Set<Integer> toDelete;
    private List<TreeNode> result;
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        result = new ArrayList<>();
        toDelete = new HashSet<>();
        
        for (int num : to_delete) {
            toDelete.add(num);
        }
        
        root = deleteHelper(root);
        
        if (root != null) {
            result.add(root);
        }
        
        return result;
    }
    
    private TreeNode deleteHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        root.left = deleteHelper(root.left);
        root.right = deleteHelper(root.right);
        
        if (toDelete.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }
        
        return root;
    }
}