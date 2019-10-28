package sim.week6;

import java.util.ArrayList;
import java.util.List;


public class InorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root;
        List<Integer> res = new ArrayList<Integer>();

        if (cur == null) return res;
        preOrder(cur, res);
        return res;
    }

    public void preOrder(TreeNode cur, List<Integer> result) {
        if (cur.left != null) {
            preOrder(cur.left, result);
        }

        result.add(cur.val);

        if (cur.right != null) {
            preOrder(cur.right, result);
        }

    }

}
