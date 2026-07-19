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
    public int cnt = 0;
    public int dfs(TreeNode node){
        if(node == null){
            return Integer.MIN_VALUE;
        }

        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);

        int subMax = Math.max(node.val, Math.max(leftMax, rightMax));

        if(node.val == subMax){
            cnt++;
        }

        return subMax;
    }
    public int countDominantNodes(TreeNode root) {
        dfs(root);

        return cnt;
    }
}