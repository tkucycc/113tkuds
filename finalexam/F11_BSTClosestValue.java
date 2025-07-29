import java.util.*;

public class F11_BSTClosestValue {
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

    public static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target) ||
                (Math.abs(root.val - target) == Math.abs(closest - target) && root.val < closest)) {
                closest = root.val;
            }

            if (target < root.val) {
                root = root.left;
            } else if (target > root.val) {
                root = root.right;
            } else {
                break; // exact match
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String[] vals = sc.nextLine().split("\\s+");
        TreeNode root = null;
        for (String s : vals) {
            int v = Integer.parseInt(s);
            root = insert(root, v);
        }

        
        int T = sc.nextInt();

        int result = closestValue(root, T);
        System.out.println("Closest: " + result);

        sc.close();
    }
}
