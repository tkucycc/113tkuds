import java.util.*;

public class F09_BinaryTreeLeftView {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int idx = 1;
        while (!q.isEmpty() && idx < nodes.length) {
            TreeNode cur = q.poll();

            
            if (idx < nodes.length && !nodes[idx].equals("-1")) {
                cur.left = new TreeNode(Integer.parseInt(nodes[idx]));
                q.offer(cur.left);
            }
            idx++;

            
            if (idx < nodes.length && !nodes[idx].equals("-1")) {
                cur.right = new TreeNode(Integer.parseInt(nodes[idx]));
                q.offer(cur.right);
            }
            idx++;
        }

        return root;
    }

    public static void printLeftView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        System.out.print("LeftView: ");
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (i == 0) {
                    System.out.print(cur.val + " "); 
                }
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] parts = line.trim().split("\\s+");

        TreeNode root = buildTree(parts);
        printLeftView(root);
        sc.close();
    }
}
