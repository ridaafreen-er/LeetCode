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
    public List<List<Integer>> zigzagLevelOrder(TreeNode r) {
        List<List<Integer>> res = new ArrayList<>();
        if (r == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(r);
        boolean rev = false;
        while (!q.isEmpty()) {
            int s = q.size();
            LinkedList<Integer> l = new LinkedList<>();
            for (int i = 0; i < s; i++) {
                TreeNode n = q.poll();
                if (rev) l.addFirst(n.val);
                else l.addLast(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            rev = !rev;
            res.add(l);
        }
        return res;
    }
}
