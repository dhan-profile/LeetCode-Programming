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
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;
            
            nodeMap.putIfAbsent(parent, new TreeNode(parent));
            nodeMap.putIfAbsent(child, new TreeNode(child));
            
            if (isLeft) {
                nodeMap.get(parent).left = nodeMap.get(child);
            } else {
                nodeMap.get(parent).right = nodeMap.get(child);
            }
            
            children.add(child);
        }
        
        for (int[] desc : descriptions) {
            if (!children.contains(desc[0])) {
                return nodeMap.get(desc[0]);
            }
        }
        
        return null;
    }
}