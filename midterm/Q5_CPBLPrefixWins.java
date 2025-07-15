import java.util.*;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n];
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        int k = Integer.parseInt(sc.nextLine());

        int[] ps = new int[n + 1]; // prefix sum 陣列，ps[0] = 0
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + a[i - 1];
        }

        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + ps[i]);
        }
        System.out.println();
        sc.close();
    }
}
/*
 * Time Complexity: O(n)
 * 說明：走訪一趟陣列建立 prefix sum 陣列，再走訪 k 次輸出結果，皆為線性時間。
 */