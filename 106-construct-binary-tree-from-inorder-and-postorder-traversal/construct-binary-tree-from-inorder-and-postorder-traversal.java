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
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] inorder, int[] postorder, int left, int right){
        if(left>right)
            return null;

        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);
        int index = find(inorder, rootValue);

        root.right = build(inorder,postorder, index+1, right);
        root.left = build(inorder, postorder, left, index-1);

        return root;
    }
     public int find(int[] inorder, int value) {

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == value)
                return i;
        }

        return -1;
    }

}