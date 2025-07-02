// file: q2seqsearch.java
import java.util.Scanner;

public class q2seqsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();       // 讀取陣列大小
        int[] arr = new int[n];     

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // 讀取陣列元素
        }

        int key = sc.nextInt();     // 讀取搜尋的 key
        int ops = 0;                // 操作次數
        boolean found = false;      // 是否找到

        for (int i = 0; i < n; i++) {
            ops++;
            if (arr[i] == key) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "Yes" : "No");
        System.out.println(ops);

        sc.close();
    }
}
