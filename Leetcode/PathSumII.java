package Leetcode;
import apple.laf.JRSUIUtils;

import java.util.*;
public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        helper(res, list, root, sum - root.val);
        return res;
    }

    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, TreeNode root, int sum){
        if (sum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
            return;
        }

        if (root.left != null){
            list.add(root.left.val);
            helper(res, list, root.left, sum - root.left.val);
            list.remove(list.size() - 1);
        }

        if (root.right != null){
            list.add(root.right.val);
            helper(res, list, root.left, sum - root.right.val);
            list.remove(list.size() - 1);
        }
    }
}
