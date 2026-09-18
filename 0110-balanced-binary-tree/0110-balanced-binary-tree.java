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
    public boolean isBalanced(TreeNode r) {
        return height(r) != -1;
    }
    int height(TreeNode n){
        if(n==null) return 0;
        int l=height(n.left), r=height(n.right);
        if(l==-1 || r==-1 || Math.abs(l-r)>1) return -1;
        return 1+Math.max(l,r);
    }
}
