class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        TreeNode flat = new TreeNode(root.val);
        
        preOrder(root, flat);
        
        root = flat;
        while(flat != null) {
            root.right = flat.right;
            root.left = null;
            flat = flat.right;
        }
    }
    
    public void preOrder(TreeNode cur, TreeNode flat) {
        flat.left = null;
        flat.right = new TreeNode(cur.val);
        
        if (cur.left != null) {
            preOrder(cur.left, flat.right);
        }
        
        if (cur.right != null) {
            preOrder(cur.right, flat.right);
        }
    }
}
