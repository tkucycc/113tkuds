import java.util.Scanner;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();            // 站點數
        String[] stations = new String[n];
        for (int i = 0; i < n; i++) {
            stations[i] = scanner.next();
        }

        String start = scanner.next();
        String end = scanner.next();

        int startIdx = -1, endIdx = -1;

        for (int i = 0; i < n; i++) {
            if (stations[i].equals(start)) startIdx = i;
            if (stations[i].equals(end)) endIdx = i;
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            int count = Math.abs(startIdx - endIdx) + 1;
            System.out.println(count);
        }
        scanner.close();
    }
}
/*
 * Time Complexity: O(n)
 * 說明：需線性掃描站名陣列一次以找出 start 與 end 的索引位置，
 * 最多走訪 n 次（n 為站數，最大 12）。
 */