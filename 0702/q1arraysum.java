import java.util.Scanner;

public class q1arraysum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();         // 讀入數字個數
        int sum = 0;
        int ops = 0;                  // 操作次數

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt(); // 讀入一個數字
            sum += value;             // 加總
            ops++;                    // 加法操作計數
        }

        System.out.println(sum);      // 總和
        System.out.println(ops);      // 操作次數
        sc.close();
    }
}
