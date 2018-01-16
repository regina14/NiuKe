package Leetcode;

import java.util.Arrays;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class BTMaximumPathSum {

    public static int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        int[] sumax = new int[2];
        Arrays.fill(sumax, Integer.MIN_VALUE);
        helper(root, sumax);
        return sumax[1];
    }

    public static int helper(TreeNode root, int[] sumax){
        if (root == null){
            return 0;
        }

        int left = helper(root.left, sumax);
        int right = helper(root.right, sumax);
        sumax[0] = Math.max(root.val, Math.max(left, right) + root.val);
        sumax[1] = Math.max(Math.max(sumax[1], left + right + root.val), sumax[0]);
        //System.out.printf("root: %d, max: %d, sum: %d\n", root.val, sumax[1], sumax[0]);
        return sumax[0];
    }

    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        TreeNode t= null;

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(3);
        t2.right = new TreeNode(5);
        t2.left.left = new TreeNode(22);
        t2.left.right = new TreeNode(18);
        t2.right.right = new TreeNode(6);

        TreeNode t3 = new TreeNode(-3);

        TreeNode t4 = new TreeNode(-1);
        t4.left = new TreeNode(2);
        t4.right = new TreeNode(-2);

        printTree(t);
        System.out.println(maxPathSum(t));

        printTree(t1);
        System.out.println(maxPathSum(t1));

        printTree(t2);
        System.out.println(maxPathSum(t2));

        printTree(t3);
        System.out.println(maxPathSum(t3));

        printTree(t4);
        System.out.println(maxPathSum(t4));

    }
}
