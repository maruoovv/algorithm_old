/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        Queue<TreeNode> searchP= new LinkedList<TreeNode>();
        Queue<TreeNode> searchQ= new LinkedList<TreeNode>();
        
        searchNode(root, p.val, searchP);
        searchNode(root, q.val, searchQ);
        while(!searchQ.isEmpty()){
            TreeNode tmpNode= searchQ.poll();
            if(searchP.contains(tmpNode)) return tmpNode;
        }

        return root;
        
    }
    public boolean searchNode(TreeNode t, int val, Queue<TreeNode> q){
        
        if(t.val==val){
            q.add(t);
            return true;
        }
        if(t.left!=null){
            if(searchNode(t.left,val,q)){
                q.add(t);  
                return true;
            } 
        }
            
        if(t.right!=null){
            if(searchNode(t.right,val,q)){
                q.add(t);
                return true;
            }
        }
            
  
        return false;
    }
}