import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static class Result {
        int height;
        int diameter;
        Result(int h, int d) {
            height = h;
            diameter = d;
        }
    }

    public static Result dfs(TreeNode root) {
        if (root == null) return new Result(0, 0);
        Result left = dfs(root.left);
        Result right = dfs(root.right);
        int height = Math.max(left.height, right.height) + 1;
        int diameter = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height);
        return new Result(height, diameter);
    }

    public static TreeNode insertLevelOrder(String[] arr) {
        if (arr.length == 0 || arr[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode cur = q.poll();
            if (!arr[i].equals("-1")) {
                cur.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(cur.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("-1")) {
                cur.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        TreeNode root = insertLevelOrder(input);
        Result res = dfs(root);
        System.out.println("Diameter: " + res.diameter);
        sc.close();
    }
}
