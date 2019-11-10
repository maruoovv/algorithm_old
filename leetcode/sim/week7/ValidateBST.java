package sim.week7;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode cur = root;
        return checkValidBST(toList(root));
    }

    public List<Integer> toList(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root.left != null)
            inOrder(root.left, list);
        list.add(root.val);
        if (root.right != null)
            inOrder(root.right, list);
    }

    public boolean checkValidBST(List<Integer> bst) {
        if (bst.isEmpty()) return true;

        int max = bst.get(0);
        for (int i = 1; i < bst.size(); i++) {
            int tmp = bst.get(i);
            if (tmp <= max) return false;
            max = tmp;
        }

        return true;
    }
}
