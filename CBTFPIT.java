class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    int preIdx = 0;
    int inIdx = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MIN_VALUE);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int stop) {
        if (preIdx >= preorder.length || inorder[inIdx] == stop) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preIdx++]);
        root.left = buildTree(preorder, inorder, root.val);
        inIdx++;
        root.right = buildTree(preorder, inorder, stop);
        
        return root;
    }
}
