import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSumBST(root.right, L, R);  
        if (root.val > R) return rangeSumBST(root.left, L, R);   

        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String[] vals = sc.nextLine().split("\\s+");
        TreeNode root = null;
        for (String s : vals) {
            int v = Integer.parseInt(s);
            root = insert(root, v);
        }

        int L = sc.nextInt();
        int R = sc.nextInt();

        int sum = rangeSumBST(root, L, R);
        System.out.println("RangeSum: " + sum);

        sc.close();
    }
}
